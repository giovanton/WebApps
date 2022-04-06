module.exports = app => {
const controller = require("../controller/plex-api-controller");

    var router = require("express").Router();

    app.use(function(req, res, next) {
        res.header('Access-Control-Allow-Origin', req.headers.origin);
        res.header(
            "Access-Control-Allow-Headers",
            "x-access-token, Origin, Content-Type, Accept"
        );
        next();
    });

    router.get("/libraries", controller.getLibraries);

    router.get("/movies", controller.getMovies);

    router.get("/recently-added", controller.getRecentlyAdded);

    router.get("/recently-viewed", controller.getRecentlyViewed);

    router.get("/tv-shows", controller.getTvShows);
    
    router.get("/music", controller.getSongs);
    
    app.use('/api/plex', router);
}