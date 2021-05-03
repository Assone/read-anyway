<template lang="pug">
el-container.view-book-detail
  el-main
    .book-meta
      el-image.book-meta__cover(:src='require("@/assets/logo.png")', fit='contain')
      .book-meta__info
        h1 {{ name }}
        p {{ author }}
        p {{ description }}
    section
      h2 特色
      p(v-html='formatFeature')
    section
      h2 目录
  el-aside
    p 出版信息
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

  name = 'JavaScript高级程序设计（第4版）';

  author = '马特·弗里斯比（Matt Frisbie）';

  description =
    '本书是JavaScript经典图书的新版。第4版涵盖ECMAScript 2019，全面、深入地介绍了JavaScript开发者必须掌握的前端开发技术，涉及JavaScript的基础特性和高级特性。书中详尽讨论了JavaScript的各个方面，从JavaScript的起源开始，逐步讲解到新出现的技术，其中重点介绍ECMAScript和DOM标准。在此基础上，接下来的各章揭示了JavaScript的基本概念，包括类、期约、迭代器、代理，等等。另外，书中深入探讨了客户端检测、事件、动画、表单、错误处理及JSON。本书同时也介绍了近几年来涌现的重要新规范，包括Fetch API、模块、工作者线程、服务线程以及大量新API。';

  feature = `
  中文版累计销量320 000+册，JavaScript“红宝书”全新升级
涵盖ECMAScript 2019，全面深入，入门和进阶俱佳
结合视频讲解+配套编程环境，助你轻松掌握JavaScript新特性与前端实践

本书是JavaScript技术经典名著，自2006年第1版中文版面世时起，至今培养了几代前端技术人员，累计销量超过32万册，被技术人员昵称为JavaScript“红宝书”。第4版涵盖ECMAScript 2019，不仅新增了5章内容，还对其余章节进行了大幅度的增补和修订。

本书第4版继承了之前版本全面深入、贴近实战的特点，在详细讲解JavaScript语言的核心之后，条分缕析地为读者展示了现有规范及实现为Web应用程序提供的各种支持和特性，既可作为入门指南，也可作为技术进阶的指导和参考。

本书主要内容包括：

基础内容——JavaScript的历史；与HTML的关联；基本类型、引用类型和内置引用类型

进阶操作——迭代器与生成器；代理与反射；对象、类与面向对象编程；函数；期约（promise）与异步编程；BOM、DOM以及客户端检测

使用JavaScript进行交互——事件、表单元素、用WebGL创建动态图形、JavaScript API、调试等

JavaScript中的数据操作——XML、JSON，以及离线时客户端如何存储数据（Web Storage和IndexedDB）

JavaScript设计模式和实践策略——工作者线程、服务线程，以及企业级开发中JavaScript编码的实践策略

JavaScript前沿——新的ES6模块；ECMAScript 2018~2019修订内容；新的库、框架和工具等



“这本书就不用我多介绍了，它是和‘犀牛书’并列的‘红宝书’，当年我学JavaScript的案头参考书之一。李松峰老师是优秀的技术译者，也是奇舞团资深的前端工程师和新人导师，我相信这本书经过松峰老师的翻译，一定能在JavaScript学习之路上让你获益良多。”

——奇舞团前团长 月影

“我认为《JavaScript高级程序设计》这本书最大的特点就是它是体系化的前端教程，它是可以拿来做前端开发的教材的。JavaScript这几年出了不少好书，但多数还是在讲单点，也有些书虽然比较全面，但是组织上不成体系，像手册、文档一样，没法拿来学。这本《JavaScript高级程序设计》就不一样，它很适合拿来系统学习。”

——程劭非（winter）

“《JavaScript高级程序设计》第1版出版时，我刚刚参加工作。我从这本书学到了前端领域的基础知识，并由此走进了前端开发的大门。感谢它一直陪伴我早期成长的岁月。后来我把这本书推荐给团队的每一位新人，作为他们的参考书。‘勿在浮沙筑高台’，希望他们通过这本书打好基础、走得更远。相信《JavaScript高级程序设计》的第4版依旧是前端工程师案头的经典参考书。”

——美团点评交通事业部终端研发团队负责人 潘魏增

“学习前端，绕不开的3本书：‘犀牛书’‘蝴蝶书’，以及这本‘红宝书’。对我而言，‘犀牛书’太厚碎，‘蝴蝶书’太薄精，都不是那么容易阅读；而这本‘红宝书’刚刚好，对初学者十分友好。”

——《深入浅出Node.js》作者 朴灵
`;

  get formatFeature() {
    return this.feature.replaceAll('\n', '<br>');
  }
}
</script>

<style lang="scss" scoped>
@include b(book, meta) {
  display: flex;

  @include e(cover) {
    flex-basis: 10vw;
    flex-shrink: 0;
  }
}
</style>
