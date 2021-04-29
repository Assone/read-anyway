<template lang="pug">
.view-book-detail
  .book-meta
    Cover(:src='require("@/assets/logo.png")')
    .book-meta__info
      h1 {{ name }}
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

import Cover from '@/components/Cover.vue';

@Component({
  components: {
    Cover,
  },
})
export default class BookDetail extends Vue {
  @Prop({ type: Number, required: true }) id!: number;
}
</script>
