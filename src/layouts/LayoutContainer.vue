<template lang="pug">
main.layout-container
  keep-alive(v-if='$route.meta.keepAlive')
    router-view
  router-view(v-else)
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class LayoutContainer extends Vue {}
</script>

<style lang="scss" scoped>
@include b(layout, container) {
  padding: {
    right: 10vw;
    left: 10vw;
  }
}
</style>
