module.exports = function(app) {

  var clients = require('../controllers/clients.controller.js');

  //Used during app start to register the app (make it online) in the database.
  //The method returns the app registration ID.
  app.post('/clients', clients.register);

  //List all apps listed as online (registered) in the database.
  app.get('/clients', clients.listAll);

  //List details of the App
  app.get('/clients/:appid', clients.details)

  //Used during app stop/destroy to set the app offline (de-register) in the database.
  app.delete('/clients', clients.deRegister);

  //Used by the app to identify itself as online.
  //If app doesn't call this endpoint after a period of time (aliveTimeOut) then
  //the app must be conidered offline.
  app.put('/clients', clients.keepAlive);

}
