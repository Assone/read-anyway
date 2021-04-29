<template lang="pug">
.view-home
  .content
    el-menu(mode='horizontal', default-active='2')
      el-menu-item(index='1') 最新
      el-menu-item(index='2') 热门
    .content__container
      Cover(
        v-for='i in 6',
        :key='i',
        :src='require("@/assets/logo.png")',
        :name='`name${i}`',
        :author='`author${i}`',
        :id='i'
      )
  aside(style='width: 300px')
    List(title='分类', :list='list', key-name='path', #default='{ path, text }')
      router-link(:to='path') {{ text }}
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

import Cover from '@/components/Cover.vue';
import List from '@/components/List.vue';

@Component({
  components: {
    List,
    Cover,
  },
})
export default class Home extends Vue {
  list = [
    { text: '计算机', path: '/?type=computer' },
    { text: '设计', path: '/?type=design' },
  ];

  created() {
    this.$api.getBookList();
  }
}
</script>

<style lang="scss" scoped>
@include b(view, home) {
  display: flex;
}

@include b(content) {
  @include e(container) {
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    gap: 20px;
  }
}
</style>
