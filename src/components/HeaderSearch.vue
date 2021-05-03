<template lang="pug">
el-autocomplete.header-search(placeholder='请输入要搜索的图书', suffix-icon='el-icon-search', type='search')
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class HeaderSearch extends Vue {
  result = [];
}
</script>

<style lang="scss">
@include b(header, search) {
  .el-input__inner {
    background: #cbd9f5;

    &::placeholder {
      color: #777;
    }
  }

  &[aria-expanded] .el-input__inner {
    background: #fff;
  }
}
</style>
