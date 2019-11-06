<template>
  <el-container class="backgroundImg">
    <el-main>
      <div class="ms-login">
        <Logo/>
        <div class="background">
          <div class="title-containter">
            <h3 class="title">{{ $t('system.login.title') }}</h3>
            <lang-select class="set-language"/>
          </div>
          <el-form class="ms-content" :model="user" :rules="rules" ref="user" v-loading="loading">
            <el-form-item prop="userName">
              <i class="el-icon-lx icon-gerentouxiang"></i>
              <el-input
                ref="userName"
                v-model="user.userName"
                type="text"
                :placeholder="$t('placeholder.username')"
                tabindex="1"
              />
            </el-form-item>
            <el-form-item prop="password">
              <span>
                <i class="el-icon-lx icon-jiesuo_o"></i>
              </span>
              <el-input
                ref="password"
                v-model="user.password"
                :type="passwordType"
                :placeholder="$t('placeholder.password')"
                tabindex="2"
              />
              <span class="show-pwd" @click="showPwd">
                <i :class="passwordType === 'password' ? 'el-icon-lx icon-yanjing_yincang_o' : 'el-icon-lx icon-yanjing_xianshi_o'" />
              </span>
            </el-form-item>
            <div class="login-btn">
              <!--<el-button type="primary" style="width:55%;" @click="Login">{{ $t('system.login.login') }}</el-button>-->
              <el-popover
                placement="bottom"
                width="400"
                trigger="manual"
                v-model="visible">
                <slidingPic :key="uuid"></slidingPic>
                <el-button type="primary" style="width:55%;" slot="reference" @click="validate">{{ $t('system.login.login') }}</el-button>
              </el-popover>
              <el-button style="width:35%;" @click="goRegister">{{ $t('system.login.register') }}</el-button>
            </div>
          </el-form>
        </div>
      </div>
    </el-main>
    <el-footer></el-footer>
  </el-container>
</template>

<script>
  import Logo from '@/components/logo'
  import LangSelect from '@/components/langSelect'
  // 组件懒加载
  const slidingPic = () => import('@/components/slidingPic')
  import { login } from '@/api/main/api';// 导入我们的api接口
  export default {
    name: "Login",
    components:{
      Logo,LangSelect,slidingPic
    },
    data(){
      return{
        url:require("../../assets/logo.png"),
        labelPosition: 'left',
        loading: false,
        passwordType:"password",
        visible:false,
        uuid:"",
        user: {
          userName: '',
          password: '',
        },
        rules: {
          userName: [
            { required: true, message: this.$t('rules.username.notnull') }
          ],
          password: [
            { required: true, message: this.$t('rules.password.notnull') }
          ]
        }
      }
    },
    methods: {
      goRegister: function () {
        this.$router.push({name:'Register'})
      },
      Login: function () {
        this.$refs.user.validate((valid) => {
          //代表通过验证 ,将参数传回后台
          if (valid){
            this.loading=true;
            let params = Object.assign({}, this.user);
            login(params)
              .then((result) => {
                if (result.success) {
                  this.$message.success(result.message);
                  sessionStorage.setItem('access-token', result.data.userToken);
                  sessionStorage.setItem('userName', this.user.userName);
                  sessionStorage.setItem('userNickName', result.data.userNickName);
                  sessionStorage.setItem('userAvatorUrl', result.data.userPicUrl);
                  this.$router.push({name:'Home'});
                }else{
                  this.$message.error(result.message);
                }
                this.loading=false;
              })
              .catch((error) => {
                this.$message.error(this.$t('tip.backstageError'));
                this.loading=false;
              });
          }
        });
      },
      showPwd() {
        if (this.passwordType === 'password') {
          this.passwordType = 'text'
        } else {
          this.passwordType = 'password'
        }
        this.$nextTick(() => {
          this.$refs.password.focus()
        })
      },
      validate(){
        this.visible = !this.visible
        this.uuid = UUID.createUUID()
      }
    },
  }
</script>

<!--替换全局样式-->
<style lang="scss">
  $bg:#283443;
  $light_gray:#fff;
  $cursor: #fff;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .el-container .el-input input {
      color: $cursor;
    }
  }

  /* reset element-ui css */
  .el-container {
    .el-input {
      //display: inline-block;
      height: 47px;
      width: 85%;

      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $light_gray;
        height: 47px;
        caret-color: $cursor;

        &:-webkit-autofill {
          box-shadow: 0 0 0px 1000px $bg inset !important;
          -webkit-text-fill-color: $cursor !important;
        }
      }
    }

    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
</style>

<!--局部样式-->
<style lang="scss" scoped>
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#eee;

  .el-container {
    min-height: 100%;
    width: 100%;
    background-position: center;
    overflow: hidden;

    .ms-login{
      position: absolute;
      left:50%;
      top:25%;
      width:350px;
      margin:-190px 0 0 -175px;
      overflow: hidden;
    }
    .background{
      background: rgba(255,255,255, 0.3);
      border-radius: 5px;
    }
    .title-containter{
      position: relative;

      .title{
        width: 100%;
        text-align: center;
        line-height: 50px;
        color: #fff;
        font-size: 20px;
        border-bottom: 1px solid #ddd;
      }

      .set-language {
        color: #fff;
        position: absolute;
        top: 7px;
        font-size: 18px;
        right: 5px;
        cursor: pointer;
      }
    }
    .ms-content{
      padding: 30px 30px;
      text-align: center;
    }
    .login-btn{
      text-align: center;
    }
    .login-btn button{
      width:100%;
      height:36px;
      margin-bottom: 10px;
    }
    .el-icon-lx{
      color: $dark_gray;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
      user-select: none;
    }
  }
</style>
