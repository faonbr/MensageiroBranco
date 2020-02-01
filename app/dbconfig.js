module.exports = {
user : process.env.NODE_ORACLEDB_USER || "<YOUR DATABASE USER HERE>",

password : process.env.NODE_ORACLEDB_PASSWORD || "<YOUR DATABASE PASSWORD HERE>",

connectString : process.env.NODE_ORACLEDB_CONNECTIONSTRING || "<YOUR DATABASE CONNECT STRING HERE>",

externalAuth : process.env.NODE_ORACLEDB_EXTERNALAUTH ? true : false
};
