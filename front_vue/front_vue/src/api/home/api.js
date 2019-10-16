import {post,get,patch,put} from '../../util/axios.js';

/*
  菜单相关接口
 */
// 获取菜单API
export const getMenu = param => post('/menu/getMenu', param);
