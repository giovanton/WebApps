const express = require('express');
const cors = require('cors');

const app = express();

var corsOptions = {
    origin: 'http://localhost:8081',
    
};

app.use(cors(corsOptions));

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
/* app.use((req, res, next) => {
    res.setHeader("Access-Control-Allow-Origin", "http://localhost");
    res.header(
      "Access-Control-Allow-Headers",
      "Origin, X-Requested-With, Content-Type, Accept"
    );
    next();
  }); */

// simple route
app.get('/', (req, res) => {
    res.json({ message: 'Bienvenido a GioServer'});
});

// set port, listen for requests
const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}.`);
});