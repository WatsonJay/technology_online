const Mock = require('mockjs') // 获取mock对象
const Random = Mock.Random // 获取random对象，随机生成各种数据，具体请翻阅文档
const domain = process.env.BASE_API // 定义默认域名，随便写
const code = 200 // 返回的状态码

// 随机生成文章数据
const postData = req => {

  console.log(req) // 请求体，用于获取参数

  let posts = [] // 用于存放文章数据的数组

  for (let i = 0; i < 4; i++) {
    let Children = [];
    for (let i = 0; i < 4; i++) {
      let string = Random.name();
      let post = {
        name:string,
        redirect:string,
        path:string,
        meta:{title: string}
      }
      children.push(post);
    }
    let string = Random.name();
    let menu = {
      name:string,
      redirect:string,
      path:string,
      meta:{title: string},
      children : children
    }
    posts.push(menu)
  }

  // 返回状态码和文章数据posts
  return {
    code,
    posts
  }
}
