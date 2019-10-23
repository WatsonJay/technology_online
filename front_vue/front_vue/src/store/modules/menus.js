const state={
  routerList: [], // 动态路由
  routerGetted: false //是否获取过路由
}

const mutations={
    SET_ROUTERLIST: (state, routerList) => {
      state.routerList = routerList
    },
    SET_ROUTERGETTED: (state, routerGetted) => {
      state.routerGetted = routerGetted
    },
}

const actions={
  setRouterList({ commit }, routerList) {
    commit('SET_ROUTERLIST', routerList)
  },
  setRouterGetted({ commit }, routerGetted) {
    commit('SET_ROUTERGETTED', routerGetted)
  },
}


export default {
  namespaced: true,
  state,
  mutations,
  actions
}
