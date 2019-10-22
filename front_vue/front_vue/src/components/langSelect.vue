<template>
  <el-dropdown trigger="click" class="international" @command="handleSetLanguage">
    <el-button size="mini">
      <i class="el-icon-lx icon-zhongyingwen"/>
    </el-button>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item :disabled="language==='zh'" command="zh">
        中文
      </el-dropdown-item>
      <el-dropdown-item :disabled="language==='en'" command="en">
        English
      </el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
    export default {
      name: "langSelect",
      computed: {
        language() {
          return this.$store.getters.language
        }
      },
      methods: {
        handleSetLanguage(lang) {
          this.$i18n.locale = lang
          this.$store.dispatch('app/setLanguage', lang)
          this.$message({
            message: 'Switch Language Success',
            type: 'success'
          })
        }
      }
    }
</script>
