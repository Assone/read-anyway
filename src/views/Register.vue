<template lang="pug">
.view-register
  el-form(:model='form', label-position='right', label-width='80px')
    el-form-item
      h1 注册
    el-form-item(label='邮箱')
      el-input(v-model='form.email', placeholder='请输入邮箱', type='email')
    el-form-item(label='昵称')
      el-input(v-model='form.nickname', placeholder='请输入昵称')
    el-form-item(label='密码')
      el-input(v-model='form.password', placeholder='请输入密码', type='password', show-password)
    el-form-item(label='确认密码')
      el-input(v-model='form.confirm', placeholder='请输入确认密码', type='password', show-password)
    el-form-item(label='验证码')
      el-input(v-model='form.verification', placeholder='请输入验证码')
    el-form-item
      el-button(:style='{ display: "block", width: "100%" }', type='primary') 注册
    el-form-item
      p 已有账号，请点击这里#[router-link(to='/login') 登陆]
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Register extends Vue {
  form = {
    email: '',
    nickname: '',
    password: '',
    confirm: '',
    verification: '',
    agree: false,
  };
}
</script>

<style lang="scss" scoped>
.view-register {
  width: 400px;
  margin: auto;
}
</style>
