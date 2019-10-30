export default {
  //application Page
  app:{


  },
  //System Tip
  tip:{
    translate:'Switch Language Success',
  },
  //Input Placeholder
  placeholder:{
    username: 'Username',
    password: 'Password',
    nickname: 'nickname',
    checkpassword: 'checkpassword',
    Email: 'Email',
    phone: 'phone',
  },
  //Check Rule
  rules:{
    common:{
      pic:'Please upload jpg/png file, and no more than 2M',
    },
    username: {
      notnull: 'plesae input usename',
    },
    password: {
      notnull: 'plesae input password',
      notmatch: 'password can not match',
    },
    userNickName: {
      notnull: 'plesae input nickname',
    },
    repassword: {
      notnull: 'plesae input password again',
    },
    Email: {
      notnull: 'please input Email',
    },
  },
  //System Page
  system:{
    login:{
      title: 'System Login',
      login: 'Login',
      register: 'Register',
    },
    register:{
      title: 'User Register',
      goback: 'back',
    },
    settings:{

    },
    guide:{

    },
  },
}
