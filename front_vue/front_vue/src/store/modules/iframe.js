const state = {
  iframeUrl: []   // 嵌套页面路由路径
}

const  mutations = {
  SET_IFRAMEURL(state, iframeUrl) {  // 设置iframeUrl
    state.iframeUrl = iframeUrl
  }
}

const actions = {
  setIframUrl({ commit }, iframeUrl) {
    commit('SET_IFRAMEURL', iframeUrl)
  },
}


export default {
  namespaced: true,
  state,
  mutations,
  actions
}
