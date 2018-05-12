import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import AutoScriptFile from '@/components/AutoScriptFile'
Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/AutoScriptFile',
      name: 'AutoScriptFile',
      component: AutoScriptFile
    }
  ]
})
