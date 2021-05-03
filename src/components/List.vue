<template lang="pug">
ul.list
  li.list__item(
    v-for='(item, index) in list',
    :key='`${item[keyName]}`',
    :class='{ "is-active": activeIndex === index }',
    @click='() => (activeIndex = index)'
  )
    slot(v-bind='item')
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class List extends Vue {
  @Prop({ type: String, required: true }) title!: string;

  @Prop({ type: Array, required: true }) list!: unknown[];

  @Prop({ type: String, required: true }) keyName!: string;

  activeIndex = 0;
}
</script>

<style lang="scss" scoped>
@include b(list) {
  border: 1px solid #a5a5a5;

  @include e(item) {
    cursor: pointer;

    padding: 20px;
    border-top: 1px solid #a5a5a5;

    @include when(active) {
      background: #4f6aa2;
      color: #fff;

      a {
        color: inherit;
      }
    }

    &:not(.is-active):hover {
      background: #dfe6f3;
    }

    a {
      color: inherit;
    }
  }
}
</style>
