import { RouteConfig } from 'vue-router';

import Home from '@/views/Home.vue';

const rules: RouteConfig[] = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
];

export default rules;
