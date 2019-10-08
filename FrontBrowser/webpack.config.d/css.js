config.module.rules.push({
    test: /\.(css|sass)$/,
    use: [
        "style-loader", // creates style nodes from JS strings
        "css-loader", // translates CSS into CommonJS
        "sass-loader" // compiles Sass to CSS, using Node Sass by default
    ]
});



/**

/\.css$/
*/