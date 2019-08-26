import router from '../router'
import {getMenu} from '../api/menu/api'

const whiteList = []

//对每次访问之前都要先看是否已经登录
router.beforeEach((to,from,next)=>{
  getMenu().then((res) => {
    console.log(res)
  });
  next();
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
