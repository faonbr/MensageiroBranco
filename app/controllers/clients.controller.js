var clients = require('../model/clients.model.js');

const scanAll = async (params) => {
  let lastEvaluatedKey = 'dummy'; // string must not be empty
  const itemsAll = [];
  while (lastEvaluatedKey) {
    const data = await documentClient.scan(params).promise();
    itemsAll.push(...data.Items);
    lastEvaluatedKey = data.LastEvaluatedKey;
    if (lastEvaluatedKey) {
      params.ExclusiveStartKey = lastEvaluatedKey;
    }
  }
  return itemsAll;
}




// Need to load different DB_files depending on the provider chosen.
if (process.env.CLOUD_PROVIDER==AWS){
  logger.log("Using AWS Cloud Provider");
}
var AWS = require('aws-sdk');
AWS.config.update({
  region: "us-east-1"
});

//Logs information.
var logger = require('../logging.js');
//basic-auth is used to validate basic authentication
//var auth = require('basic-auth');

exports.register = function(req, res){
  logger.log('-----------------');
  logger.log('Entering apps register function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};

exports.listAll = function(req, res){
  logger.log('-----------------');
  logger.log('Entering apps listAll function.');
  answer = {"clients":[]}

  // logger.log('Setting up params');
  // var params = {
  //   TableName: 'MsgBranco-Clients',
  //   ProjectionExpression: "id, IP, name, status"
  // };
  //
  // logger.log('Preparing docClient');
  // var docClient = new AWS.DynamoDB.DocumentClient();
  // logger.log("Scanning Movies table.");
  // docClient.scan(params, onScan);

  const documentClient = new aws.DynamoDB.DocumentClient();
  var params = {
    // ProjectionExpression: "id, IP, name, status",
    TableName: 'MsgBranco-Clients'
  };
  const answer = scanAll(params);

  logger.log('response: '+ answer);
  res.status(200).json(answer);
};

exports.details = function(req, res){
  logger.log('-----------------');
  logger.log('Entering apps details function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};

exports.deRegister = function(req, res){
  logger.log('-----------------');
  logger.log('Entering apps deRegister function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};

exports.keepAlive = function(req, res){
  logger.log('-----------------');
  logger.log('Entering apps keepAlive function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};





function onScan(err, data) {
    if (err) {
        logger.error("Unable to scan the table. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        // print all the itens from the dynamoDB table
        logger.log("Scan succeeded.");
        data.Items.forEach(function(item) {
           logger.log(item);
        });

        // // continue scanning if we have more data, because
        // // scan can retrieve a maximum of 1MB of data per call
        // if (typeof data.LastEvaluatedKey != "undefined") {
        //     console.log("Scanning for more...");
        //     params.ExclusiveStartKey = data.LastEvaluatedKey;
        //     docClient.scan(params, onScan);
        // }
    }
}
