<template lang="pug">
.view-home
  Banner
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import Banner from '@/components/Banner.vue';

@Component({
  components: {
    Banner,
  },
})
export default class Home extends Vue {}
</script>
