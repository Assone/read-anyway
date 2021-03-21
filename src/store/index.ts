import Vue from 'vue';
import Vuex, { createLogger } from 'vuex';

import { isDev } from '@/utils/is';

Vue.use(Vuex);

export default new Vuex.Store({
  strict: isDev,
  plugins: isDev ? [createLogger()] : [],
  state: {},
  mutations: {},
  actions: {},
  modules: {},
});
