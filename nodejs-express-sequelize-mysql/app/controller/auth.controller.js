const db = require("../models");
const config = require("../config/auth.config");
const User = db.users;
const Role = db.Role;
const plexApi = require("plex-api");

const Op = db.Sequelize.Op;

var jwt = require("jsonwebtoken");
bcrypt = require("bcryptjs");

exports.signup = (req, res) => {
    User.create({
        userName: req.body.username,
        userEmail: req.body.email,
        userLogin: req.body.userlogin,
        password: bcrypt.hashSync(req.body.password, 8),
        createdBy: '0000-0000-0000-0000',
        modifiedBy: '0000-0000-0000-0000'
    })
        .then(user => {
            if (req.body.roles) {
                Role.findAll({
                    where: {
                        name: {
                            [Op.or]: req.body.roles
                        }
                    }
                }).then(roles => {
                    user.setRoles(roles).then(() => {
                        res.send({ message: "Usuario registrado correctamente." });
                    });
                })
            } else {
                user.setRoles([3]).then(() => {
                    res.send({ message: "Usuario registrado correctamente." });
                });
            }
        })
        .catch(err => {
            res.status(500).send({ message: err.message });
        });
};

exports.signin = (req, res) => {
    User.findOne({
        where: {
            userLogin: req.body.userlogin
        }
    })
        .then(user => {
            if (!user) {
                return res.status(404).send({ message: "Usuario no encontrado." });
            }

            var passwordIsValid = bcrypt.compareSync(
                req.body.password,
                user.password
            );

            if (!passwordIsValid) {
                return res.status(401).send({
                    accessToken: null,
                    message: "Password no válido."
                });
            }

            var token = jwt.sign({ id: user.userGuid }, config.secret, {
                expiresIn: 86400
            });

            var authorities = [];
            user.getRoles().then(roles => {
                for (let i = 0; i < roles.length; i++) {
                    authorities.push("ROL_" + roles[i].name.toUpperCase());
                }
                res.status(200).send({
                    id: user.userGuid,
                    userName: user.userName,
                    userEmail: user.userEmail,
                    userLogin: user.userLogin,
                    roles: authorities,
                    accessToken: token
                });
            });
        })
        .catch(err => {
            res.status(500).send({ message: err.message });
        });
};