const state={
  routerList: [], // 动态路由
  routerGetted: false //是否获取过路由
}

const mutations={
    set_routerList: (state, routerList) => {
      state.routerList = routerList
    },
    set_routerGetted: (state, routerGetted) => {
      state.routerGetted = routerGetted
    },
}

const actions={

}


export default {
  namespaced: true,
  state,
  mutations,
  actions
}
