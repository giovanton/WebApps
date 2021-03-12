const { DataTypes } = require("sequelize");
const { sequelize, Sequelize } = require(".");

module.exports = (sequelize, Sequelize) => {
    const Role = sequelize.define("role",{
        id: {
            type: DataTypes.INTEGER,
            primaryKey: true
        },
        name: {
            type: DataTypes.STRING
        }
    });

    return Role;
};