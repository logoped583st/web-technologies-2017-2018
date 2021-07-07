const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
    entry: "./script.js",
    output: {
      filename: "main.js"
    },
    devtool: 'source-map'
  }