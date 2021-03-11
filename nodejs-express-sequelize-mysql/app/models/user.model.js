const { Sequelize, DataTypes, DATE } = require("sequelize");
const { sequelize } = require(".");

module.exports = (sequelize, Sequelize) => {
    const User = sequelize.define("user", {
        userName: {
            type: DataTypes.STRING,
            field: 'user_name',
            allowNull: false
        },
        userGuid: {
            type: DataTypes.UUID,
            defaultValue: Sequelize.UUIDV4,
            primaryKey: true,
            allowNull: false,
            field: 'user_guid'
        },
        userLogin: {
            type: DataTypes.STRING,
            allowNull: false,
            field: 'user_login'
        },
        userEmail: {
            type: DataTypes.STRING,
            allofNull: false,
            field: 'user_email'
        },
        password: {
            type: DataTypes.STRING,
            allowNull: true
        },
        createdBy: {
            type: DataTypes.UUID,
            allowNull: false,
            field: 'created_by'
        },
        modifiedBy: {
            type: DataTypes.UUID,
            allowNull: false,
            field: 'modified_by'
        },
        createdAt: {
            type: DataTypes.DATE,
            allowNull: false,
            field: 'created_date',
            defaultValue: DataTypes.NOW
        },
        updatedAt: {
            type: DataTypes.DATE,
            allowNull: false,
            field: 'modified_date',
            defaultValue: DataTypes.NOW
        }
    });

    return User;
};