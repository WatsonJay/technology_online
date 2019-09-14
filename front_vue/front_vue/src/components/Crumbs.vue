<template>
  <div class="crumbs">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item v-for="item in crumbsList":key="item.path"><a :href="item.path==''?'/':item.path">{{item.meta.title}}</a></el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
  export default {
    name: "crumbs",
    data(){
      return{
        crumbsList:[]
      }
    },
    watch:{
      $route(){
        this.getBreadcrumb()
      }
    },
    created() {
      this.getBreadcrumb()
    },
    methods:{
      getBreadcrumb(){
        this.crumbsList = this.$route.matched
      }
    }
  }
</script>

<style scoped>

</style>
