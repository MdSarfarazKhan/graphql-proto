require('babel-register')({
  presets: [ 'env' ]
})

// Import the rest of our application.
module.exports = require('./server-mock.js')
module.exports = require('./schema-mock.js')

