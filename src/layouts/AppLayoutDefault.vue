<template lang="pug">
.layout-default
  slot(name='header')
  slot
  slot(name='footer')
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class AppLayoutDefault extends Vue {}
</script>
