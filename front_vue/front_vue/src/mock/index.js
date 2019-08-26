var axios = require('axios')
var MockAdapter = require('axios-mock-adapter')

import {menus} from "./data/menus"

export default {
  init(){
    var mock = new MockAdapter(axios)
    mock.onPost('/menu/getMenu').reply(200, {
      success:true, code: 1001, msg: '请求成功', menus
    })
  }
}
