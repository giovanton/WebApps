module.exports = app => {
    const users = require("../controller/user.controller");

    var router = require("express").Router();

    // Create a new user
    router.post("/", users.create);

    // Retrieve All
    router.get("/",users.findAll);

    // Update
    router.put("/:id",users.update);

    app.use('/api/users', router);
}