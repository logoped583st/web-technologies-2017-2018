const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
    entry: ["./view.js","./presenter.js","./model.js","./dom.js"],
    output: {
      filename: "main.js"
    },
    devtool: 'source-map'
  }