config.module.rules.push(
    {
        test: /\.js$/,
        use: ['source-map-loader'],
        enforce: 'pre'
    })
config.devtool= "inline-source-map"

/*if (defined.PRODUCTION) {
    config.plugins.push(new webpack.optimize.UglifyJsPlugin({
        minimize: true
    }));
}*/