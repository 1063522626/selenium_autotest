<template>
  <div class="login">
  <i-button type="ghost" id="bname">用户名</i-button>
  <Input v-model="user" placeholder="请输入用户名" style="width: 300px"/>
  <br>
  <i-button type="ghost" id="password">密码</i-button>
  <Input v-model="pass" type="password" placeholder="请输入密码" style="width: 300px"/>
  <br>
  <i-button type="info" id="login" @click="loginhandle">登录</i-button>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      user: '',
      pass: ''
    }
  },
  methods: {
    loginhandle () {
      var _this = this
      this.$http({
        method: 'post',
        url: 'http://www.lubo.com:8080/login',
        data: JSON.stringify({
          bname: this.user,
          password: this.pass
        })
      }).then(function (response) {
        _this.$store.state.user = response.data
        localStorage.setItem('bname', response.data.bname)
        localStorage.setItem('pass', response.data.password)
        if (_this.$store.state.user != null) {
          _this.$router.push({path: 'AutoScriptFile'})
        }
      })
    }
  }
}
</script>

<style scoped>
.login{
  margin-top: 300px;
  /*margin-left: 50px;*/
}
#bname{
  width: 60px;
  padding-right: 3px;
  padding-top: 5px;
  padding-bottom: 5px;
}
#password{
  width: 60px;
  margin-top: 5px;
  padding-top: 5px;
  padding-bottom: 5px;
}
#login{
  width: 60px;
  margin-top: 10px;
  /*margin-left: ;*/
  padding-top: 3px;
  padding-bottom: 3px;
}
</style>
