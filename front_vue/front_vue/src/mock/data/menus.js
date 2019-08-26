import Mock from 'mockjs';
const Random = Mock.Random // 获取random对象，随机生成各种数据，具体请翻阅文档

let menus = [] // 用于存放菜单数据的数组
for (let i = 0; i < 4; i++) {
  let children = [];
  for (let i = 0; i < 4; i++) {
    let string = Random.word();
    let childMenu = {
      name: string,
      redirect: string,
      path: string,
      meta: {title: string}
    }
    children.push(childMenu);
  }
  let string = Random.word();
  let menu = {
    name: string,
    redirect: string,
    path: "/"+string,
    meta: {title: string},
    children: children
  };
  menus.push(menu)
}

export {menus}
