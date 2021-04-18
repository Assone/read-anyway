import { RouteConfig } from 'vue-router';

const rules: RouteConfig[] = [
  {
    path: '/user',
    name: 'User',
    meta: {
      auth: true,
    },
    component: () => import(/* webpackChunkName: "error" */ '@/views/User.vue'),
  },
];

export default rules;
