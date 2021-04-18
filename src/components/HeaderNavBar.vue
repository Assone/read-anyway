<template lang="pug">
el-menu.nav-bar(mode='horizontal', router, :default-active='$route.path')
  el-submenu(index='2')
    template(#title) 作品分类
    el-menu-item(index='2-1') 文学
    el-menu-item(index='2-2') 小说
    el-menu-item(index='2-3') 工具书
  el-menu-item(index='/all') 全部作品
  el-menu-item(index='/rank') 排行
  el-menu-item(index='/finish') 完本
  el-menu-item(index='/free') 免费
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class HeaderNavBar extends Vue {}
</script>
