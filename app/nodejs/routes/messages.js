module.exports = function(app) {

  var messages = require('../controllers/messages.controller.js');

  //Send a message to another client (either if the app is online or not).
  app.post('/messages', messages.publish);

  //List all messages sent to the client.
  app.get('/messages', messages.listAll);

  //List all messages marked as unread by the client.
  app.get('/messages/unread', messages.receiveLatests)


}
