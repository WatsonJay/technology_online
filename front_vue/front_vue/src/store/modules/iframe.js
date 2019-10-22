const state = {
  iframeUrl: []   // 嵌套页面路由路径
}

const  mutations = {
  setIFrameUrl(state, iframeUrl) {  // 设置iframeUrl
    state.iframeUrl = iframeUrl
  }
}

const actions = {

}


export default {
  namespaced: true,
  state,
  mutations,
  actions
}
