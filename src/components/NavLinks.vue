<template lang="pug">
nav.nav-bar__links(role='navigation')
  router-link.nav-links__item(v-for='{ href, text } in links', :key='href', :to='href') {{ text }}
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class NavLink extends Vue {
  @Prop({ type: Array, required: true }) links!: { text: string; href: string }[];
}
</script>
