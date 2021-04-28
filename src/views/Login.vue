<template lang="pug">
.view-login
  el-form(:model='form', label-position='right', label-width='80px')
    el-form-item
      h1 登陆
    el-form-item(label='邮箱')
      el-input(v-model='form.email', placeholder='请输入邮箱', type='email')
    el-form-item(label='密码')
      el-input(v-model='form.password', placeholder='请输入密码', type='password', show-password)
    el-form-item
      el-checkbox(v-model='form.remenber') 下次自动登陆
    el-form-item
      el-button(:style='{ display: "block", width: "100%" }') 登陆
    el-form-item
      el-row(type='flex', justify='space-between')
        el-col(:span='8')
          span 没有账号？#[router-link(to='/register') 注册]
        el-col(:span='5')
          span 找回密码
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Login extends Vue {
  form = {
    email: '',
    password: '',
    remenber: true,
  };
}
</script>

<style lang="scss" scoped>
.view-login {
  width: 400px;
  margin: auto;
}
</style>
