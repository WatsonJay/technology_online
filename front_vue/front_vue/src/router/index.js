import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

//所有权限通用路由表
//如首页和登录页和一些不用权限的公用页面
export const constantRouterMap = [
  {
    path: '/login',
    name: 'Login',
    component: resolve => require(['@/views/login/index.vue'], resolve)
  },
  {
    path: '/register',
    name: 'Register',
    component: resolve => require(['@/views/register/index.vue'], resolve)
  },
  {
    path: '/',
    name: 'Home',
    component: resolve => require(['@/views/home/index.vue'], resolve),
    meta: { title: '系统首页' },
    children: []
  },
]
export const asyncRouterMap = [
  {
    path:'*',
    component : resolve => require(['@/views/errorPage/404.vue'], resolve)
  },
]
export default new Router({
  mode: 'history',
  routes: constantRouterMap
})
