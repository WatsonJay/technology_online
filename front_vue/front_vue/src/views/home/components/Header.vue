<template>
  <div class="home-header">
    <div class="collapse-btn" @click="collapseChange">
      <i class="el-icon-lx icon-yingyongAPP"></i>
    </div>
    <div class="header-logo">技术支撑管理系统</div>
    <div class="header-right">
      <div class="header-user-con">
        <!-- 全屏显示 -->
        <div class="btn-fullscreen" @click="handleFullScreen">
          <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
            <i class="el-icon-data-board"></i>
          </el-tooltip>
        </div>
        <!-- 消息中心 -->
        <div class="btn-message">
          <el-badge is-dot :hidden="readAll" class="item">
            <el-tooltip effect="dark" :content="message?`有${message}条未读消息`:`消息中心`" placement="bottom">
              <router-link to="/tabs">
                <i class="el-icon-bell"></i>
              </router-link>
            </el-tooltip>
          </el-badge>
        </div>
        <!-- 用户头像 -->
        <div class="user-avator">
            <el-avatar :src="avator_pic"></el-avatar>
        </div>
        <!-- 用户名下拉菜单 -->
        <el-dropdown @command="handleCommand">
          <span class="el-dropdown-link">
            {{userNickName}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="2">个人中心</el-dropdown-item>
            <el-dropdown-item divided command="loginOut">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
  import Logo from '@/components/logo'
  import { EventBus } from '@/vendor/bus';
  export default {
    name: "Header",
    components:{
      Logo,
    },
    created(){
      this.userNickName = sessionStorage.getItem("userNickName");
      this.avator_pic = sessionStorage.getItem("userAvatorUrl");
    },
    data(){
      return{
        fullscreen:false,
        readAll:false,
        collapse: false,
        message: '',
        userNickName:'',
        avator_pic:require('@/assets/img/user.png'),
      }
    },
    methods:{
      collapseChange() {
        this.collapse = !this.collapse;
        EventBus.$emit('collapse', this.collapse);
      },
      handleCommand(command){
        if (command == 'loginOut'){
          sessionStorage.removeItem('access-token');
          sessionStorage.removeItem('userName');
          sessionStorage.removeItem('userNickName');
          sessionStorage.removeItem('userAvatorUrl');
          this.$router.push({name:'Login'})
        }
      },
      // 全屏事件
      handleFullScreen(){
        if (this.fullscreen) {
          if (document.exitFullscreen) {
            document.exitFullscreen();
          } else if (document.webkitCancelFullScreen) {
            document.webkitCancelFullScreen();
          } else if (document.mozCancelFullScreen) {
            document.mozCancelFullScreen();
          } else if (document.msExitFullscreen) {
            document.msExitFullscreen();
          }
        } else {
          let element = document.documentElement;
          if (element.requestFullscreen) {
            element.requestFullscreen();
          } else if (element.webkitRequestFullScreen) {
            element.webkitRequestFullScreen();
          } else if (element.mozRequestFullScreen) {
            element.mozRequestFullScreen();
          } else if (element.msRequestFullscreen) {
            // IE11
            element.msRequestFullscreen();
          }
        }
        this.fullscreen = !this.fullscreen;
      }
    },
    mounted(){
      var _this = this;
      if (document.body.clientWidth < 1500){
        this.collapseChange();
      };
      window.onresize = function() {
        if (document.body.clientWidth < 1500) {
          if (_this.collapse==false){
            _this.collapseChange();
          }
        }
      }
    },
  }
</script>

<style scoped>
  .home-header{
    position: relative;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #fff;
  }
  .collapse-btn{
    float: left;
    padding: 0 21px;
    cursor: pointer;
    line-height: 70px;
  }
  .header-logo{
    float: left;
    width:250px;
    line-height: 70px;
  }
  .header-right{
    float: right;
    padding-right: 50px;
  }
  .header-user-con{
    display: flex;
    height: 70px;
    align-items: center;
  }
  .btn-message, .btn-fullscreen{
    position: relative;
    width: 30px;
    height: 30px;
    text-align: center;
    border-radius: 15px;
    cursor: pointer;
  }
  .btn-fullscreen{
    margin-right: 5px;
    font-size: 24px;
  }
  .btn-message .el-icon-bell{
    color: #fff;
  }
  .user-avator{
    margin-left: 20px;
  }
  .user-avator el-avatar{
    display: block;
    width:40px;
    height:40px;
  }
  .el-dropdown-link{
    color: #fff;
    margin-left: 10px;
    cursor: pointer;
  }
  .el-dropdown-menu__item{
    text-align: center;
  }
</style>
