export default {
  //应用翻译
  app:{

  },
  //输入水印
  placeholder:{
    username: '用户名',
    password: '密码',
    nickname: '昵称',
    checkpassword: '确认密码',
    Email: '邮箱',
    phone: '电话',
  },
  //系统提示
  tip:{
    translate:'切换语言成功',
    backstageError:'后端异常，请联系管理员',
    slidingPic:'拖动左边滑块完成上方拼图',
  },
  //校验规则
  rules:{
    common:{
      pic:'请点击上传jpg/png文件，且不超过2M',
    },
    username: {
      notnull: '请输入用户名',
    },
    password: {
      notnull: '请输入密码',
      notmatch: '密码不匹配',
    },
    userNickName: {
      notnull: '请输入昵称',
    },
    repassword: {
      notnull: '请再次输入密码',
    },
    Email: {
      notnull: '请输入邮箱',
    },
  },
  //系统页面
  system:{
    login:{
      title: '系统登陆',
      login: '登陆',
      register: '注册',
    },
    register:{
      title: '用户注册  ',
      goback: '返回',
    },
    settings:{

    },
    guide:{

    },
  },
}
