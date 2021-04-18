<template lang="pug">
el-autocomplete.header-search(placeholder='请输入要搜索的图书')
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class HeaderSearch extends Vue {
  result = [];
}
</script>

<style lang="scss" scoped>
@include b(header, search) {
  width: 100%;
}
</style>
