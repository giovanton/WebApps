const plexApi = require("plex-api");
const db = require("../models");
const User = db.users;

const client = new plexApi({ 
    hostname: 'www.giogalnet.es', 
    username: 'giovantong@gmail.com', 
    password: 'C0n3cta2', 
    managedUser: { name: 'Giovanni Galecio', pin: '7903' } });

exports.getLibraries = (req, res) => {
    client.query("/library/sections").then(results => {
        console.log(results);
        res.send(results);
    }, (err) => {
        console.error("Error recuperando librerías", err);
    });
}

exports.getMovies = (req, res) => {
    client.query("/library/sections/1/all").then(results => {
        console.log(results);
        res.send(results);
    }, (err) => {
        console.error("Error recuperando peliculas", err);
    });
}

exports.getRecentlyAdded = (req, res) => {
    client.query("/library/recentlyAdded").then(results => {
        res.send(results);
    }, (err) => {
        console.error("Error recuperando recientes", err);
    });
}

exports.getRecentlyViewed = (req, res) => {
    client.query("/channels/recentlyViewed").then(results => {
        res.send(results);
    }, (err) => {
        console.error("Error recuperando vistas", err);
    });
}

exports.getTvShows = (req, res) => {
    client.query("/library/sections/2/all").then(results => {
        console.log(results);
        res.send(results);
    }, (err) => {
        console.error("Error recuperando series", err);
    });
}

exports.getSongs = (req, res) => {
    client.find("/library/sections/3/all").then(results => {
        console.log(results);
        res.send(results);
    }, (err) => {
        console.error("Error recuperando música", err);
    });
}