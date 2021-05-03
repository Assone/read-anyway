<template lang="pug">
el-header.header
  .header__inner
    el-image(:src='require("@/assets/logo.png")', style='height: 60px; width: 60px', fit='cover')
    router-link(to='/' :class='$style["nav-link"]') 图书
    HeaderSearch
  el-button-group(style='flex')
    el-button(@click='$router.push("/register")') 注册
    el-button(@click='$router.push("/login")') 登陆
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import HeaderSearch from './HeaderSearch.vue';

@Component({
  components: {
    HeaderSearch,
  },
})
export default class Header extends Vue {}
</script>

<style lang="scss" module>
@include b(nav, link) {
  margin: 0 20px;
  height: 60px;
  line-height: 60px;

  text-decoration: none;
  text-shadow: 0 1px 4px rgb(0 0 0 / 20%);
  color: #fff;
}
</style>

<style lang="scss" scoped>
@include b(header) {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  height: 70px;
  padding: 0 10vw;

  background: #3b5998;
  box-shadow: 0 2px 10px rgb(0 0 0 / 25%);

  @include e(inner) {
    display: flex;
    align-items: center;
  }
}
</style>
