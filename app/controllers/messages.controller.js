//var clients = require('../model/messages.model.js');
// var aws-dynamoDB = require('../providers/aws-dynamodb.js');

const TABLE_NAME = 'MsgBranco-Messages';

var aws = require('aws-sdk');
aws.config.update({
  region: "us-east-1"
});
const dynamodb = new aws.DynamoDB.DocumentClient();

//Logs information.
var logger = require('../logging.js');
//basic-auth is used to validate basic authentication
//var auth = require('basic-auth');

exports.publish = function(req, res){
  logger.log('-----------------');
  logger.log('Entering messages publish function.');
  answer = {"messages":[]}
  res.status(200).json(answer);
};

exports.listAll = function(req, res){
  logger.log('-----------------');
  logger.log('Entering messages listAll function.');
  var params = {
    ProjectionExpression: "fromid, toid, message, sentdate",
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

exports.receiveLatests = function(req, res){
  logger.log('-----------------');
  logger.log('Entering messages receiveLatests function.');
  answer = {"messages":[]}
  res.status(200).json(answer);
};
