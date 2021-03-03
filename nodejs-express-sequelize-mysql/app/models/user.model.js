const { Sequelize, DataTypes } = require("sequelize");
const { sequelize } = require(".");

module.exports = (sequelize, Sequelize) => {
    const User = sequelize.define("user", {
        userName: {
            type: DataTypes.STRING
        },
        userGuid: {
            type: DataTypes.UUID,
            defaultValue: Sequelize.UUIDV4,
            primaryKey: true,
            allowNull: false
        },
        userLogin: {
            type: DataTypes.STRING,
            allowNull: false
        },
        userEmail: {
            type: DataTypes.STRING
        },
        createdBy: {
            type: DataTypes.UUID,
            allowNull: false
        },
        modifiedBy: {
            type: DataTypes.UUID,
            allowNull: false
        }
    });

    return User;
};