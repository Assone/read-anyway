<template lang="pug">
header.app-header
  ToggleMenuButton
  NavBarTitle(v-if='showTitle', title='title')
  NavLinks(:links='links')
  Search
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import ToggleMenuButton from './ToggleMenuButton.vue';
import NavBarTitle from './NavBarTitle.vue';
import NavLinks from './NavLinks.vue';
import Search from './Search.vue';

@Component({
  components: {
    ToggleMenuButton,
    NavBarTitle,
    NavLinks,
    Search,
  },
})
export default class AppHeader extends Vue {
  showTitle = true;

  links: { text: string; href: string }[] = [
    { text: 'Home', href: '/' },
    { text: 'Discover', href: '/discover' },
    { text: 'Library', href: '/library' },
  ];
}
</script>
