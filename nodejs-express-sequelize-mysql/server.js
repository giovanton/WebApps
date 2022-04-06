const express = require('express');
const logger = require('morgan');
const cors = require('cors');
const https = require('https'), fs = require('fs');

const options = {
    key: fs.readFileSync("/home/giovanton/Projects/WebApps/nodejs-express-sequelize-mysql/giogalnet.es.key"),
    cert: fs.readFileSync("/home/giovanton/Projects/WebApps/nodejs-express-sequelize-mysql/giogalnet.es.cer")
}

const app = express();

var corsOptions = {
    origin: 'https://localhost:4200',  //Desarrollo
    //origin: 'https://www.giogalnet.es',  //Producción
    optionSuccessStatus: 200    
};

//app.use(cors(corsOptions));
//log requests to console
app.use(logger('dev'));
// parse requests of content-type - application/json
app.use(express.json());

// parse requests of content-type - application/x-www-form-urlencoded
app.use(express.urlencoded({ extended: true}));


const db = require('./app/models');
db.sequelize.sync().then(() => {
    console.log('Drop and re-sync db.');
});

require('./app/routes/user.routes')(app);
require('./app/routes/role.routes')(app);
require('./app/routes/auth.routes')(app);
require('./app/routes/plex-api.routes')(app);

// Add Access Control Allow Origin headers
app.use((req, res, next) => {
    res.eader('Access-Control-Allow-Origin', req.headers.origin);
    res.header(
      'Access-Control-Allow-Headers',
      'Origin, X-Requested-With, Content-Type, Accept'
    );
    next();

    app.options('*', (req, res) => {
         res.header('Access-Control-Allow-Origin', req.headers.origin);
         res.header(
            'Access-Control-Allow-Headers',
            'Origin, X-Requested-With, Content-Type, Accept'
          );
         res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
         res.send();
    });
  });

// simple route
app.get('/', (req, res) => {
    res.json({ message: 'Bienvenido a GioServer'});
});

app.all('/api/*', (req, res, next) => {
    /**
     * Response settings
     * @type {Object}
     */
     var responseSettings = {
        "AccessControlAllowOrigin": req.headers.origin,
        "AccessControlAllowHeaders": "Content-Type,X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5,  Date, X-Api-Version, X-File-Name",
        "AccessControlAllowMethods": "POST, GET, PUT, DELETE, OPTIONS",
        "AccessControlAllowCredentials": true
    };

    /**
     * Headers
     */
    res.header("Access-Control-Allow-Credentials", responseSettings.AccessControlAllowCredentials);
    res.header("Access-Control-Allow-Origin",  responseSettings.AccessControlAllowOrigin);
    res.header("Access-Control-Allow-Headers", (req.headers['access-control-request-headers']) ? req.headers['access-control-request-headers'] : "x-requested-with");
    res.header("Access-Control-Allow-Methods", (req.headers['access-control-request-method']) ? req.headers['access-control-request-method'] : responseSettings.AccessControlAllowMethods);

    if ('OPTIONS' == req.method) {
        res.sendStatus(200);
    }
    else {
        next();
    }

});

var secureapp = https.createServer(options, app);
secureapp.listen(8443, () => {
    console.log("server starting on port: 8443");
})

// set port, listen for requests
const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}.`);
});
