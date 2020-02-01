var clients = require('../model/messages.model.js');

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
  answer = {"messages":[]}
  res.status(200).json(answer);
};

exports.receiveLatests = function(req, res){
  logger.log('-----------------');
  logger.log('Entering messages receiveLatests function.');
  answer = {"messages":[]}
  res.status(200).json(answer);
};
