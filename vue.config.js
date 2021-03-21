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
};
