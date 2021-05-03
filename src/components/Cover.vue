<template lang="pug">
article.cover
  el-image.cover__inner(
    :src='src',
    fit='contain',
    :alt='name',
    @click='() => $router.push(`/book/${id}`)'
  )
  .cover-meta
    router-link.cover-meta__name(v-if='id', :to='`/book/${id}`') {{ name }}
    span.cover-meta__author(v-if='author') {{ author }}
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class Cover extends Vue {
  @Prop({ type: String }) name?: string;

  @Prop({ type: Number }) id?: number;

  @Prop({ type: String }) author?: string;

  @Prop({ type: String, required: true }) src!: string;
}
</script>

<style lang="scss" scoped>
@include b(cover) {
  @include e(inner) {
    cursor: pointer;
    max-width: 116px;
    max-height: 150px;

    box-shadow: 2px 2px 10px rgb(0 0 0 / 20%);

    &:hover {
      box-shadow: 3px 3px 14px rgb(0 0 0 / 20%);
    }
  }
}

@include b(cover, meta) {
  display: flex;
  flex-direction: column;

  margin-top: 10px;

  @include e(author) {
    line-height: 1.6;
  }

  @include e(name) {
    text-decoration: none;
  }
}
</style>
