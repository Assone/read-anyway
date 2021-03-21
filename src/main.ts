import Vue from 'vue';

import router from './router';
import store from './store';

import './plugins/registerServiceWorker';
import './plugins/hooks';
import './plugins/interceptors';
import './plugins/elementUI';
import './plugins/directives';

import api from './apis';

import App from './App.vue';
import './styles/index.scss';

Vue.config.productionTip = false;
Vue.prototype.$api = api;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
