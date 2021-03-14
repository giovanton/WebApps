const db = require("../models");
const Role = db.roles;
const User = db.users;
const Op = db.Sequelize.Op;

// create and save
exports.create = (req, res) => {
    if (!req.body.userName) {
        res.status(400).send({
            message: "Content can not be empty!"
        });
        return;
    }

    const user = {
        userName: req.body.userName,
        userLogin: req.body.userLogin,
        userEmail: req.body.userEmail,
        password: req.body.password,
        createdBy: req.body.createdBy,
        modifiedBy: req.body.modifiedBy
    };

    User.create(user)
        .then(data => {
            res.send(data);
        })
        .catch(err => {
            res.status(500).send({
                message:
                    err.message || "Some error occurred while creating user."
            });
        });
};

// Retrieve all
exports.findAll = (req, res) => {
    const name = req.query.name;
    var condition = name ? { userName: { [Op.like]: `%${name}%` } } : null;

    User.findAll({
        include: [{
            model: Role,
            required: true
        }],
        where: condition
    })
        .then(data => {
            res.send(data);
        })
        .catch(err => {
            res.status(500).send({
                message:
                    err.message || "Some error occurred while retrieving users."
            });
        });
};

// Find a single user with id
exports.findOne = (req, res) => {
    const id = req.params.id
    const user = User.findOne({ where: { userGuid: id } })
};

// Update an user by id
exports.update = (req, res) => {
    const id = req.params.id;

    User.update(req.body, {
        where: { userGuid: id }
    })
        .then(user => {
            if (req.body.roles) {
                const roleNames = req.body.roles.map(r => r.name);
                Role.findAll({
                    where: {
                        name: {
                            [Op.or]: roleNames
                        }
                    }
                }).then(roles => {
                    User.findOne({ where: { userGuid: id } }).then(u => {
                        u.setRoles(roles.map(r => r.id)).then(() => {
                            res.status(200);
                        })
                            .then(num => {
                                if (num == 1) {
                                    res.send(u);
                                } else {
                                    res.send({
                                        message: `No se pudo actualizar el usuario con id: ${id}`
                                    });
                                }
                            })
                    })
                }).catch(err => {
                    res.status(500).send({
                        message: "Error actualizando usuario con id: " + id
                    });
                });
            };
        })
};
// Delete
exports.delete = (req, res) => {

};

// Delete All
exports.deleteAll = (req, res) => {

};

exports.allAccess = (req, res) => {
    res.status(200).send("Contenido Público");
};

exports.userBoard = (req, res) => {
    res.status(200).send("Contenido de Usuario");
};

exports.moderatorBoard = (req, res) => {
    res.status(200).send("Contenido de Moderador");
};

exports.administratorBoard = (req, res) => {
    res.status(200).send("Contenido de Administrador");
}