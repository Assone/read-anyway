<template lang="pug">
footer.footer
  p.footer__description MIT Licensed | Copyright © 2020-present Wxcrushedforward
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Footer extends Vue {}
</script>

<style lang="scss" scoped>
@include b(footer) {
  max-width: 960px;
  margin: 0 auto;

  @include e(description) {
    text-align: center;
  }
}
</style>
