/**
 * @type import('@vue/cli-service/types/ProjectOptions').ProjectOptions
 */
module.exports = {
  css: {
    requireModuleExtension: true,
    sourceMap: true,
    loaderOptions: {
      scss: {
        prependData: '@import "~@/styles/import.scss";',
        sourceMap: true,
      },
    },
  },
  configureWebpack: {
    module: {
      rules: [
        {
          test: /\.js$/,
          exclude: /node_modules(?!(\/|\\)pdfjs-dist)/,
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env'],
            plugins: ['@babel/plugin-proposal-optional-chaining'],
          },
        },
      ],
    },
  },
};
