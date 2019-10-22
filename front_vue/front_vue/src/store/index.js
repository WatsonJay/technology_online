import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'

Vue.use(Vuex);

// you do not need `import app from './modules/app'`
// it will auto require all vuex module from modules file
//引入
const modulesFiles = require.context('./modules', true, /\.js$/)

const modules = modulesFiles.keys().reduce((modules,modulePath)=>{
  // set './*.js' => '*s'
  const moduleName = modulePath.replace(/^\.\/(.*)\.\w+$/, '$1')
  const value = modulesFiles(modulePath)
  modules[moduleName] = value.default
  return modules
},{})

console.log(modules)

const store = new Vuex.Store({
  modules,
  getters
})

console.log(store)

export default store
