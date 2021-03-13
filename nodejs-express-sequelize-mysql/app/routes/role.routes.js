module.exports = app => {
    const roles = require("../controller/role.controller");

    var router = require("express").Router();

    // Retrieve All
    router.get("/",roles.findAll);

    app.use('/api/roles', router);
}