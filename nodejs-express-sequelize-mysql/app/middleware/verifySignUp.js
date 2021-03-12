const db = require("../models");
const ROLES = db.ROLES;
const User = db.users;

checkDuplicateUsernameOrEmail = (req, res, next) => {
    User.findOne({
        where: {
            userName: req.body.username
        }
    }).then(user => {
        if (user) {
            res.status(400).send({
                message: "El nombre de usuario ya está en uso."
            });
            return;
        }

        User.findOne({
            where: {
                userLogin: req.body.userlogin
            }
        }).then(user => {
            if (user) {
                res.status(400).send({
                    message: "El login de usuario ya está en uso."
                });
                return;
            }

            User.findOne({
                where: {
                    userEmail: req.body.email
                }
            }).then(user => {
                if (user) {
                    res.status(400).send({
                        message: "Este correo ya está en uso."
                    });
                    return;
                }

                next();
            });
        });
    });
};

checkRolesExisted = (req, res, next) => {
    if (req.body.roles) {
        for (let i = 0; i < req.body.roles.length; i++) {
            if (!ROLES.includes(req - body.roles[i])) {
                res.status(400).send({
                    message: "El Rol no existe: " + req.body.roles[i]
                });
                return;;
            }
        }
    }
    next();
};

const verifySignUp = {
    checkDuplicateUsernameOrEmail: checkDuplicateUsernameOrEmail,
    checkRolesExisted: checkRolesExisted
};

module.exports = verifySignUp;