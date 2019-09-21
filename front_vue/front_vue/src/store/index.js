import Vue from 'vue'
import Vuex from 'vuex'
import menus from './modules/menus'
import iframe from './modules/iframe'
import getters from './getters'

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    menus,
    iframe
  },
  getters
})

export default store
