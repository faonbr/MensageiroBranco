module.exports = function(app) {

  var messageDao = require('../dao/message.dao.js');

  //List all messages stored.
  app.get('/v1/messages', messagesController.listAll);

  //List all messages of the specified client.
  app.post('/v1/clients/:id/messages', messagesController.retreiveAllMessages);

  //List all unread messages of the specified client.
  app.get('/v1/clients/:id/messages/unread', messagesController.retreiveUnreadMessages);

  //List all read messages of the specified client.
  app.get('/v1/clients/:id/messages/read', messagesController.retreiveReadMessages);

  //Post message from the specified client.
  app.get('/v1/clients/:id/messages', messagesController.receiveLatests);

  //Update read status of the specified message of the specified client.
  app.put('/v1/clients/:id/messages/:messageId', messagesController.updateMessageToReadStatus);

}
