const db = require("../models");
const User = db.users;
const Op = db.Sequelize.Op;

// create and save
exports.create = (req, res) => {
    if(!req.body.userName){
        res.status(400).send({
            message: "Content can not be empty!"
        });
        return;
    }

    const user = {
        userName: req.body.userName,
        userLogin: req.body.userLogin,
        userEmail: req.body.userEmail
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
    const name = req.query.userName;
    var condition = name ? { name: { [Op.like]: `%${name}%` } } : null;

    User.findAll({ where: condition })
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

};

// Update an user by id
exports.update = (req, res) => {

};

// Delete
exports.delete = (req, res) => {

};

// Delete All
exports.deleteAll = (req, res) => {

};