'use strict'

const ExtractTextPlugin = require('extract-text-webpack-plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin')

const devtool = 'eval-source-map'

const entry = {
  vendors: './src/vendors',
  main: ['babel-polyfill', './src/main']
}

const output = {
  filename: '[name].js',
  path: './dist'
}

const extensions = [
  '',
  '.js',
  '.css',
  '.html'
]

const loaders = [{
  test: /.js$/,
  exclude: /node_modules/,
  loaders: ['ng-annotate', 'babel']
}, {
  test: /.css$/,
  loader: ExtractTextPlugin.extract('style', 'css')
}, {
  test: /.html$/,
  exlude: /node_modules/,
  include: /static/,
  loader: 'html'
}, {
  test: /.html$/,
  exclude: /node_modules/,
  include: /src/,
  loaders: [
    'ngtemplate?requireAngular',
    'html'
  ]
}, {
  test: /.(ico|png|eot|svg|ttf|woff|woff2)$/,
  loader: 'url?limit=10000'
}]

const plugins = [
  new ExtractTextPlugin('[name].css'),
  new HtmlWebpackPlugin({
    hash: true,
    template: './static/index.html',	
    inject: 'head'
  })
]

module.exports = {
  devtool,
  entry,
  output,
  resolve: {
    extensions
  },
  module: {
    loaders
  },
  plugins
}
