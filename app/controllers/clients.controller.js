var clients = require('../model/clients.model.js');
var aws = require('aws-sdk');
aws.config.update({
  region: "us-east-1"
});
const documentClient = new aws.DynamoDB.DocumentClient();

const scanAll = async (params) => {
  let lastEvaluatedKey = 'dummy'; // string must not be empty
  itemsAll = [];
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
  //answer = {"clients":[]}

  aws.config.getCredentials(function(err) {
    if (err) console.log(err.stack);
    // credentials not loaded
    else {
      console.log("Access key:", aws.config.credentials.accessKeyId);
      console.log("Secret access key:", aws.config.credentials.secretAccessKey);
    }
  });
  var params = {
    // ProjectionExpression: "id, IP, name, status",
    TableName: 'MsgBranco-Clients'
  };
  //answer = scanAll(params);
  let lastEvaluatedKey = 'dummy'; // string must not be empty
  answer = [];
  while (lastEvaluatedKey) {
    const data = documentClient.scan(params).promise();
    answer.push(...data.Items);
    lastEvaluatedKey = data.LastEvaluatedKey;
    if (lastEvaluatedKey) {
      params.ExclusiveStartKey = lastEvaluatedKey;
    }
  }
  return answer;

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
