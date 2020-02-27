module.exports = function(app) {

  var clientDao = require('../dao/client.dao.js');

  //List all apps listed as online (registered) in the database.
  app.get('/clients', clientsController.retreiveAllClients);

  //List details of the App
  app.get('/clients/:id', clientsController.retreiveClient)

  //Used during app start to register the app (make it online) in the database.
  //The method returns the app registration ID.
  app.post('/clients/:id', clientsController.registerClientOnline);

  //Used during app stop/destroy to set the app offline (de-register) in the database.
  app.delete('/clients/:id', clientsController.registerClientOffline);

  //Used by the app to identify itself as online.
  //If app doesn't call this endpoint after a period of time (aliveTimeOut) then
  //the app must be conidered offline.
  app.put('/clients/:id', clientsController.updateInfo);

}
