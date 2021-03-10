const { sequelize, Sequelize } = require(".");

module.exports = (sequelize, Sequelize) => {
    const Role = sequelize.define("roles",{
        id: {
            Type: Sequelize.INTEGER,
            primaryKey: true
        },
        name: {
            Type: Sequelize.STRING
        }
    });

    return Role;
};