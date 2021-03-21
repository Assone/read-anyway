<template lang="pug">
article.menu-button(@click='$emit("toggle")')
  svg.icon(
    xmlns='http://www.w3.org/2000/svg',
    aria-hidden='true',
    role='img',
    viewBox='0 0 448 512'
  )
    path(
      fill='currentColor',
      d='M436 124H12c-6.627 0-12-5.373-12-12V80c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12zm0 160H12c-6.627 0-12-5.373-12-12v-32c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12zm0 160H12c-6.627 0-12-5.373-12-12v-32c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12z',
      class
    )
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class ToggleMenuButton extends Vue {}
</script>

<style lang="scss">
@include b(menu, button) {
  position: absolute;
  top: 0.6rem;
  left: 1rem;
  display: none;
  padding: 0.6rem;
  cursor: pointer;

  .icon {
    display: block;
    width: 1.25rem;
    height: 1.25rem;
  }
}

@media screen and (max-width: 719px) {
  @include b(menu, button) {
    display: block;
  }
}
</style>
