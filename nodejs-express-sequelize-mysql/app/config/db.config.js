module.exports = {
    HOST: "gioserver.giogalnet.es",
    USER: "giovanton",
    PASSWORD: "Mysql#1",
    DB: "gioserverdb",
    dialect: "mariadb",
    pool: {
      max: 5,
      min: 0,
      acquire: 30000,
      idle: 10000
    }
  };