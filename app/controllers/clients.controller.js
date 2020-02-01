var clients = require('../model/clients.model.js');

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
