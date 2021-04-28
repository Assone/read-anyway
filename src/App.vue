<template lang="pug">
#app
  Header
  el-backtop
  LayoutContainer
  Footer
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';
import LayoutContainer from '@/layouts/LayoutContainer.vue';

@Component({
  components: {
    Header,
    Footer,
    LayoutContainer,
  },
})
export default class App extends Vue {}
</script>
