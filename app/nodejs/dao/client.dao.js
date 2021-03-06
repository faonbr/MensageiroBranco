// var clients = require('../model/clients.model.js');
// var aws-dynamoDB = require('../providers/aws-dynamodb.js');

const TABLE_NAME = 'MsgBranco-Clients';

var aws = require('aws-sdk');
aws.config.update({
  region: "us-east-1"
});
const dynamodb = new aws.DynamoDB.DocumentClient();

//Logs information.
var logger = require('../logging.js');
//basic-auth is used to validate basic authentication
//var auth = require('basic-auth');

exports.retreiveAllClients = function(req, res){
  logger.log('-----------------');
  logger.log('Entering retreiveAllClients function.');
  //answer = {"clients":[]}

  var params = {
    ProjectionExpression: "id, ip, description, onlinestatus, lasttimeon",
    TableName: TABLE_NAME
  };

  //There is a limit of 1Mb of messages. Need to recursively call the function.
  dynamodb.scan(params, function(err, data) {
    if (err){
      logger.log(err, err.stack); // an error occurred
      res.status(500);
    }else{
      logger.log(data);           // successful response
      logger.log('response: '+ data);
      res.status(200).json(data);
    }
  });

};

exports.retreiveClient = function(req, res){
  logger.log('-----------------');
  logger.log('Entering retreiveClient function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};

exports.registerClientOnline = function(req, res){
  logger.log('-----------------');
  logger.log('Entering registerClientOnline function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};

exports.registerClientOffline = function(req, res){
  logger.log('-----------------');
  logger.log('Entering registerClientOffline function.');
  answer = {"clients":[]}
  res.status(200).json(answer);
};

exports.updateInfo = function(req, res){
  logger.log('-----------------');
  logger.log('Entering updateInfo function.');
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
