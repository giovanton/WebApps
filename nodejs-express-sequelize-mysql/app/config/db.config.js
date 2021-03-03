module.exports = {
    HOST: "192.168.1.254",
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