// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueResource from 'vue-resource'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/iconfont/iconfont.css';
import './assets/css/icon.css';

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueResource);

// //对每次访问之前都要先看是否已经登录
// router.beforeEach((to,from,next)=>{
//   if(to.path== '/login' || to.path== '/register'){
//     sessionStorage.removeItem('access-token');
//     sessionStorage.removeItem('userName');
//     next();
//   }else {
//     const token = sessionStorage.getItem('access-token');
//     if(!token){
//       next({path:'/login'});
//     }else {
//       next()
//     }
//   }
// });

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
