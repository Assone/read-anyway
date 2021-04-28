<template lang="pug">
ul.list
  h2.list__title {{ title }}
  li.list__item(v-for='item in list', :key='`${item[keyName]}`')
    slot(v-bind='item')
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class List extends Vue {
  @Prop({ type: String, required: true }) title!: string;

  @Prop({ type: Array, required: true }) list!: unknown[];

  @Prop({ type: String, required: true }) keyName!: string;
}
</script>

<style lang="scss" scoped>
@include b(list) {
  list-style-type: none;
}
</style>
