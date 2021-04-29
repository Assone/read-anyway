<template lang="pug">
article.cover
  el-image(v-bind='$attrs')
  router-link.cover__name(v-if='id', :to='`/book/${id}`') {{ name }}
  p.cover__author(v-if='author') {{ author }}
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class Cover extends Vue {
  @Prop({ type: String }) name?: string;

  @Prop({ type: Number }) id?: number;

  @Prop({ type: String }) author?: string;
}
</script>
