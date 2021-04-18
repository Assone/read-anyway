<template lang="pug">
el-header(height='10vw')
  el-row.site-header(type='flex', align='middle', justify='space-between')
    el-col(:span='1')
      router-link(to='/')
        el-image.site-header__logo(:src='require("@/assets/logo.png")', fit='cover')
    el-col(:span='8')
      HeaderSearch
    el-col(:span='2')
      el-button(@click='handleClick') 我的书架
      el-dialog(title='登陆', :visible.sync='showDiglog', width='30vw', lock-scroll, center)
        .login-info
          el-input(v-model='account', placeholder='请输入帐号')
          el-input(v-model='password', placeholder='请输入密码', show-password)
        .login-options
          el-checkbox(v-model='rememberMe') 记住我
        el-button 登陆
  HeaderNavBar
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import HeaderNavBar from './HeaderNavBar.vue';
import HeaderSearch from './HeaderSearch.vue';

@Component({
  components: {
    HeaderNavBar,
    HeaderSearch,
  },
})
export default class Header extends Vue {
  showDiglog = false;

  rememberMe = false;

  account = '';

  password = '';

  handleClick() {
    this.showDiglog = true;
  }
}
</script>
