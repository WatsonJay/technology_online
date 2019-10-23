import router from '../router'
// 引入store
import store from '../store'
import {getMenu} from '../api/home/api'

const whiteList = []

//对每次访问之前都要先看是否已经登录
router.beforeEach((to,from,next)=>{
  if (store.getters.routerGetted){
    next()
  }else{
    gotoRouter(to, next);
  }
  // if(to.path== '/login' || to.path== '/register'){
  //   sessionStorage.removeItem('access-token');
  //   sessionStorage.removeItem('userName');
  //   next();
  // }else {
  //   const token = sessionStorage.getItem('access-token');
  //   if(!token){
  //     next({path:'/login'});
  //   }else {
  //     next()
  //   }
  // }
});

function gotoRouter(to, next) {
  getMenu().then((res) => {
    console.log('解析后端动态路由', res.data);
    const asyncRouter = res.data;
    // 一定不能写在静态路由里面，否则会出现，访问动态路由404的情况.所以在这列添加
    asyncRouter.push({ path: '*', redirect: '/404', hidden: true });
    return asyncRouter
  })
  .then(asyncRouter => {
    router.addRoutes(asyncRouter) // vue-router提供的addRouter方法进行路由拼接
    store.dispatch('menus/setRouterList', asyncRouter)
    store.dispatch('menus/setRouterGetted', true)
    next({ ...to, replace: true }) // hack方法 确保addRoutes已完成
  })
}
