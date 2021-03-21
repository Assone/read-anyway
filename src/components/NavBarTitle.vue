<template lang="pug">
router-link.nav-bar__title(to='/')
  el-image(v-if='logo', :src='logo')
  | {{ title }}
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class NavBarTitle extends Vue {
  @Prop({ type: String, required: true }) title!: string;

  @Prop({ type: String }) logo?: string;
}
</script>
