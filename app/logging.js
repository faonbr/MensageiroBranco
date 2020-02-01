const isDebugEnabled =  process.env.DEBUG_LOGIN ? process.env.DEBUG_LOGIN.toLowerCase() === 'true': false;

function debugEnabled() {
  if(isDebugEnabled) console.log('debug mode on');
  return isDebugEnabled;
}
exports.debugEnabled = debugEnabled;

function log( message ) {
  if ( !isDebugEnabled ) {
    return;
  }
  console.log(message);
}

exports.log = log;

function error( message ) {
  console.error(message);
}

exports.error = error;
