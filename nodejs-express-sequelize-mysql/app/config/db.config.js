module.exports = {
    HOST: "GioServer.giogalnet.es",
    USER: "giovanton",
    PASSWORD: "MySql#1",
    DB: "gioserverdb",
    dialect: "mariadb",
    pool: {
      max: 5,
      min: 0,
      acquire: 30000,
      idle: 10000
    }
  };