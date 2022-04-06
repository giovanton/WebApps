module.exports = app => {
    const users = require("../controller/user.controller");

    var router = require("express").Router();

    app.use(function(req, res, next) {
        res.header('Access-Control-Allow-Origin', req.headers.origin);
        res.header(
            "Access-Control-Allow-Headers",
            "x-access-token, Origin, Content-Type, Accept"
        );
        next();
    });

    // Create a new user
    router.post("/", users.create);

    // Retrieve All
    router.get("/",users.findAll);

    // Update
    router.put("/:id",users.update);

    app.use('/api/users', router);
}