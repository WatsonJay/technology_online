// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueResource from 'vue-resource'
import Cookies from 'js-cookie'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'normalize.css/normalize.css' // a modern alternative to CSS resets
//集成iconfont图标
import '@/assets/iconfont/iconfont.css';
// global css
import '@/styles/index.scss'
//模拟后端数据（测试用）
import Mock from './mock'
// 引入store
import store from './store'
//前端拼接后台权限
import  '@/router/permission'
//vue-i18n 多语言版本处理
import i18n from './lang'

//启动mock
if(process.env.MOCK_NEEDED){
  Mock.init()
}

Vue.config.productionTip = false

Vue.use(ElementUI);
//Vue.use(VueResource);
Vue.use({
  //size: Cookies.get('size') || 'medium', // set element-ui default size
  i18n: (key, value) => i18n.t(key, value)
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  i18n,
  router,
  store,
  components: { App },
  template: '<App/>'
})
