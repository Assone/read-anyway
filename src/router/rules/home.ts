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
  {
    path: '/register',
    name: 'Register',
    component: () => import(/* webpackChunkName: "register" */ '@/views/Register.vue'),
  },
  {
    path: '/book/:id',
    name: 'Book Detail',
    props: (router) => ({ id: Number(router.params.id) }),
    component: () => import(/* webpackChunkName: "book" */ '@/views/BookDetail.vue'),
  },
  {
    path: '/preview/:id',
    name: 'Book Preview',
    props: (router) => ({ id: Number(router.params.id) }),
    component: () => import(/* webpackChunkName: "preview" */ '@/views/Preview.vue'),
  },
];

export default rules;
