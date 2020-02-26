// Import packages
var express = require('express');
var app = express();

//var bodyParser = require('body-parser');
//app.use(bodyParser.json({ type: 'application/json' }));

var config = require('./config.js');

//Routes to Users endpoint
var clients = require('./routes/clients.js')(app);
var messages = require('./routes/messages.js')(app);

console.log('Current Time Millis: '+ Date.now() );

// Set Port
app.set('port', (process.env.PORT || config.APP_DEFAULT_PORT));
app.listen(app.get('port'), function(){
	console.log('Server started on port '+ app.get('port'));
});
