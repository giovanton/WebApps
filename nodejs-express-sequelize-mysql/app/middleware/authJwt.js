const jwt = require("jsonwebtoken");
const config = require("../config/auth.config.js");
const db = require("../models");
const User = db.user;

verifyToken = (req, res, next) => {
    let token = req.headers["x-access-token"];

    if(!token){
        return res.status(403).send({
            message: "¡No tiene token!"
        });
    }

    jwt.verify(token, config.secret, (err, decoded) => {
        if(err){
            return res.status(401).send({
                message: "¡No autorizado!"
            });
        }
        req.userGuid = decoded.id;
        next();
    });
};

isAdmin = (req, res, next) => {
    User.findByPk(req.userGuid).then(user => {
        user.getRoles().then(roles => {
            for(let i = 0; i < roles.length; i++){
                if(roles[i].nam === "administrador"){
                    next();
                    return;
                }
            }

            res.status(403).send({
                mmessage: "Requiere tener ROl de Administrador"
            });
            return;
        });
    });
};

isModerator = (req, res, next) => {
    User.findByPk(req.userGuid).then(user => {
        user.getRoles().then(roles => {
            for(let i = 0; i < roles.length; i++){
                if(roles[i].name === "moderador"){
                    next();
                    return;
                }
            }

            res.status(403).send({
                message: "Requiere Rol de moderador."
            });
        });
    });
};

isModeratorOrAdmin = (req, res, next) => {
    User.findByPk(req.userGuid).then(user => {
        user.getRoles().then(roles => {
            for(let i = 0; i < roles.length; i++){
                if(roles[i].name === "moderador"){
                    next();
                    return;
                }

                if(roles[i].name === "administrador" ){
                    next();
                    return;
                }
            }

            res.status(403).send({
                message: "Requiere Rol de Moderador o Administrador"
            });
        });
    });
};

const authJwt = {
    verifyToken: verifyToken,
    isAdmin: isAdmin,
    isModerator: isModerator,
    isModeratorOrAdmin: isModeratorOrAdmin
};

module.exports = authJwt;
