import { RouteConfig } from 'vue-router';

const rules: RouteConfig[] = [
  {
    path: '*',
    name: 'Error',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "error" */ '@/views/Error.vue'),
  },
];

export default rules;
