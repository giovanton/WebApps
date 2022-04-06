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
    res.header('Access-Control-Allow-Origin', 'https://localhost:4200');
    res.header(
      'Access-Control-Allow-Headers',
      'Origin, X-Requested-With, Content-Type, Accept'
    );
    next();

    app.options('*', (req, res) => {
         res.header('Access-Control-Allow-Origin', 'https://localhost:4200');

         res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
         res.send();
    });
  });

// simple route
app.get('/', (req, res) => {
    res.json({ message: 'Bienvenido a GioServer'});
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
