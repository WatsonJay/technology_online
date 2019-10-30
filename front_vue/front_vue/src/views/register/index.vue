<template>
  <el-container class="backgroundImg">
    <el-main class="ms-register">
      <Logo/>
      <el-container class="background">
        <el-header class="title-containter">
          <h3 class="title">{{ $t('system.register.title') }}</h3>
          <lang-select class="set-language"/>
        </el-header>
        <el-main>
          <el-upload
            class="avatar-uploader"
            ref="upload"
            name="smfile"
            action="/sm.ms/upload"
            :show-file-list="false"
            :on-change="imgPreview"
            :on-success="uploadSuccess"
            :on-error="uploadError"
            :before-upload="beforeUpload"
            :auto-upload="false">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-user avatar-uploader-icon"></i>
            <div slot="tip" class="el-upload__tip"><span style="color: red">*</span>{{ $t('rules.common.pic') }}</div>
          </el-upload>
          <el-form class="ms-content" :model="user" :rules="rules" ref="user" v-loading="loading">
            <el-form-item prop="userName">
              <i class="el-icon-user"></i>
              <el-input v-model="user.userName" :placeholder="$t('placeholder.username')"></el-input>
            </el-form-item>
            <el-form-item prop="userNickName">
              <i class="el-icon-postcard"></i>
              <el-input v-model="user.userNickName" :placeholder="$t('placeholder.nickname')"></el-input>
            </el-form-item>
            <el-form-item prop="password" required>
            <span>
              <i class="el-icon-key"></i>
            </span>
              <el-input ref="password" :type="passwordType" v-model="user.password" :placeholder="$t('placeholder.password')"></el-input>
              <span class="show-pwd" @click="showPwd">
              <i :class="passwordType === 'password' ? 'el-icon-lx icon-yanjing_yincang_o' : 'el-icon-lx icon-yanjing_xianshi_o'" />
            </span>
            </el-form-item>
            <el-form-item prop="rePassword">
            <span>
              <i class="el-icon-connection"></i>
            </span>
              <el-input type="password" v-model="user.rePassword" :placeholder="$t('placeholder.checkpassword')"></el-input>
            </el-form-item>
            <el-form-item prop="userMail">
              <i class="el-icon-message"></i>
              <el-input v-model="user.userMail" :placeholder="$t('placeholder.Email')"></el-input>
            </el-form-item>
            <el-form-item prop="userPhone">
              <i class="el-icon-phone"></i>
              <el-input v-model="user.userPhone" :placeholder="$t('placeholder.phone')"></el-input>
            </el-form-item>
            <div class="login-btn">
              <el-button type="primary" style="width:65%;" @click.native="registerUser">{{ $t('system.login.register') }}</el-button>
              <el-button style="width:25%;" @click="goBack">{{ $t('system.register.goback') }}</el-button>
            </div>
          </el-form>
        </el-main>
      </el-container>
    </el-main>
  </el-container>
</template>

<script>
  import Logo from '@/components/logo'
  import LangSelect from '@/components/langSelect'
  import { registerUser } from '@/api/main/api';// 导入我们的api接口
  export default {
    name: "Register",
    components:{
      Logo,LangSelect,
    },
    data(){
      var validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error(this.$t('rules.password.notnull')));
        } else {
          if (this.rePassword !== '') {
            this.$refs.user.validateField('rePassword');
          }
          callback();
        }
      };
      var validateRePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error(this.$t('rules.repassword.notnull')));
        } else if (value !== this.user.password) {
          callback(new Error(this.$t('rules.password.notmatch')));
        } else {
          callback();
        }
      };
      return{
        user: {
          userName: '',
          userNickName: '',
          password: '',
          rePassword: '',
          userMail: '',
          userPhone: '',
          picName:'',
          userPicUrl:'',
          userPicDelUrl:'',
        },
        imageUrl: '',
        loading: false,
        passwordType:"password",
        rules:{
          userName: [
            { required: true, message: this.$t('rules.username.notnull'), trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' },
            { pattern: /^[a-zA-Z0-9_]+$/, message: '请输入合法的字符' }
          ],
          userNickName: [
            { required: true, message: this.$t('rules.userNickName.notnull'), trigger: 'blur' },
            { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' },
            { pattern: /^[\u4e00-\u9fa5a-z0-9_]+$/, message: '请输入合法的字符' }
          ],
          password: [
            { validator: validatePassword, trigger: 'blur' }
          ],
          rePassword: [
            { validator: validateRePassword, trigger: 'blur' }
          ],
          userMail: [
            { required: true, message: this.$t('rules.Email.notnull'), trigger: 'blur' },
            { pattern: /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/, message: '请输入合法的邮箱' }
          ],
          userPhone: [
            { pattern: /^1(3|4|5|6|7|8|9)\d{9}$/, message: '请输入合法的电话号'}
          ],
        },
      };
    },
    methods: {
      goBack: function () {
        this.$router.go(-1)
      },
      showPwd(){
        if(this.passwordType === 'password'){
          this.passwordType = 'text'
        }else {
          this.passwordType = 'password'
        }
        this.$nextTick(() => {
          this.$refs.password.focus()
        })
      },
      imgPreview (file, fileList) {
        let fileName = file.name;
        let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
        if (regex.test(fileName.toLowerCase ())) {
          this.imageUrl = URL.createObjectURL(file.raw);
        } else {
          this.$message.error('请选择图片文件');
        }
      },
      registerUser(){
        this.$refs.user.validate((valid) => {
          //代表通过验证 ,将参数传回后台
          if (valid){
            this.$refs.upload.submit();
            }
        });
      },
      uploadSuccess(res, file) {
        if(res.code == 'success'){
          this.user.userPicUrl = res.data.url;
          this.user.userPicDelUrl = res.data.delete;
          this.user.picName = res.data.filename;
          this.loading=true;
          let params = Object.assign({}, this.user);
          registerUser(params)
            .then((result) => {
              if (result.success) {
                this.$message.success(result.message);
                this.$router.push({name:'Login'})
              }else{
                this.$message.error(result.message);
              }
              this.loading=false;
            })
            .catch((error) => {
              this.$message.error("后端异常，请联系管理员");
              this.loading=false;
            });
        }else {
          this.$message.error("图片上传异常，请更换图片或联系管理员");
          this.loading=false;
        }
      },
      uploadError(res, file) {
        this.$message.error("图片上传异常，请更换图片或联系管理员");
        this.loading=false;
      },
      beforeUpload(file){
        const isLt2M = file.size / 1024 / 1024 < 2;
        const fileName = file.name;
        let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
        const hasFIle=regex.test(fileName.toLowerCase ())
        if (!hasFIle) {
          this.$message.error('请选择图片文件');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return  isLt2M && hasFIle;
      }
    }
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

<style lang="scss" scoped>
  $dark_gray:#889aa4;

  .el-container{
    width: 100%;
    height: 100%;
    position:relative;
    overflow: hidden;

    .ms-register{
      position: absolute;
      left:0;
      right:0;
      bottom: 20px;
      top:20px;
      margin: auto;
      width:35%;
      min-width: 400px;
      text-align: center;
      overflow: hidden;

      .background{
        background: rgba(255,255,255, 0.3);
        border-radius: 6px;
        height: 80%;

        .title-containter{
          position: relative;

          .title{
            width: 100%;
            text-align: center;
            line-height: 40px;
            color: #fff;
            font-size: 20px;
            border-bottom: 1px solid #ddd;

          }

          .set-language {
            color: #fff;
            position: absolute;
            top: 20px;
            font-size: 18px;
            right: 5px;
            cursor: pointer;
          }
        }

        .ms-content{
          text-align: center;
          z-index: 1;
          margin-top: 10px;
          postion:absolute;
          overflow-y: auto;

          .show-pwd {
            position: absolute;
            right: 10px;
            top: 7px;
            font-size: 16px;
            color: $dark_gray;
            cursor: pointer;
            user-select: none;
          }

          .login-btn{
            text-align: center;
          }
          .login-btn button{
            width:100%;
            height:36px;
            margin-bottom: 10px;
          }
        }

        .el-upload__tip{
          color: #fff;
        }

        .avatar-uploader-icon {
          font-size: 28px;
          color: #8c939d;
          width: 90px;
          height: 90px;
          line-height: 90px;
          text-align: center;
        }

        .avatar {
          margin-top: 10px;
          width: 90px;
          height: 90px;
          display: block;
          border-radius: 50%;
        }

      }
    }
  }



</style>
