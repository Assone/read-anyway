import api from '@/apis';

declare module 'vue/types/vue' {
  interface Vue {
    $api: typeof api;
  }
}
