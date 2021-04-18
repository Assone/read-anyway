<template lang="pug">
#app
  Header
  el-backtop
  router-view
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import Header from '@/components/Header.vue';

@Component({
  components: {
    Header,
  },
})
export default class App extends Vue {}
</script>
