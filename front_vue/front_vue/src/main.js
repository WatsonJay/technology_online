// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueResource from 'vue-resource'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//集成iconfont图标
import './assets/iconfont/iconfont.css';
//模拟后端数据（测试用）
import Mock from './mock'
// 引入store
import store from './store'
//前端拼接后台权限
import  '@/router/permission'
//启动mock
if(process.env.MOCK_NEEDED){
  Mock.init()
}

Vue.config.productionTip = false

Vue.use(ElementUI);
//Vue.use(VueResource);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
