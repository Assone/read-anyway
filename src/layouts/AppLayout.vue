<template lang="pug">
component(:is='layout')
  router-view
  template(#header)
    AppHeader
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import AppHeader from '@/components/AppHeader.vue';

@Component({
  components: {
    AppHeader,
  },
})
export default class AppLayout extends Vue {
  get layout() {
    return () => import(`@/layouts/${this.$route.meta.layout || 'AppLayoutDefault'}.vue`);
  }
}
</script>
