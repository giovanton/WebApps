module.exports = app => {
const controller = require("../controller/plex-api-controller");

    var router = require("express").Router();

    router.get("/libraries", controller.getLibraries);

    router.get("/movies", controller.getMovies);

    router.get("/recently-added", controller.getRecentlyAdded);

    router.get("/recently-viewed", controller.getRecentlyViewed);

    router.get("/tv-shows", controller.getTvShows);
    
    router.get("/music", controller.getSongs);
    
    app.use('/api/plex', router);
}