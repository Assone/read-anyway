import Vue from 'vue';
import VueRouter from 'vue-router';

import routes from './rules';

import meta from './guards/meta';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach(meta);

export default router;
