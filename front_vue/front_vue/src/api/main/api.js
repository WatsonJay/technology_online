import {post,get,patch,put} from '../../util/axios.js';

/*
  用户相关接口
 */
//用户注册API
export const registerUser = param => post('/user/registerUser', param);
//用户登陆API
export const login = param => post('/user/login', param);
