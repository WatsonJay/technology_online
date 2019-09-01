import Vue from 'vue'
import Vuex from 'vuex'
import menus from './modules/menus'
import getters from './getters'

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    menus
  },
  getters
})

export default store
