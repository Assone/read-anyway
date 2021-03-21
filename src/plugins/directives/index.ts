import Vue, { VueConstructor } from 'vue';

import debounce from './debounce';

const directives = {
  debounce,
};

Vue.use({
  install(vue: VueConstructor): void {
    Object.entries(directives).forEach(([key, directive]) => {
      vue.directive(key, directive);
    });
  },
});
