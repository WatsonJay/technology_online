import {post,get,patch,put} from '../util/axios.js';

//用户注册API
export const registerUser = p => post('/user/registerUser', p);
//用户登陆API
export const login = p => post('/user/Login', p);
