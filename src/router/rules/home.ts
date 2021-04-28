import { RouteConfig } from 'vue-router';

import Home from '@/views/Home.vue';

const rules: RouteConfig[] = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "login" */ '@/views/Login.vue'),
  },
];

export default rules;
