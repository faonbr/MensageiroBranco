module.exports = function(app) {

  var clientDao = require('../dao/client.dao.js');

  app.get('/ping', function(req, res){
    logger.log('-----------------');
    logger.log('Entering ping function.');
    answer = "Pong";
    res.status(200).json(answer);
  );

  //List all apps listed as online (registered) in the database.
  app.get('/v1/clients', clientDao.retreiveAllClients);

  //List details of the App
  app.get('/v1/clients/:id', clientDao.retreiveClient)

  //Used during app start to register the app (make it online) in the database.
  //The method returns the app registration ID.
  app.post('/v1/clients/:id', clientDao.registerClientOnline);

  //Used during app stop/destroy to set the app offline (de-register) in the database.
  app.delete('/v1/clients/:id', clientDao.registerClientOffline);

  //Used by the app to identify itself as online.
  //If app doesn't call this endpoint after a period of time (aliveTimeOut) then
  //the app must be conidered offline.
  app.put('/v1/clients/:id', clientDao.updateInfo);

}
