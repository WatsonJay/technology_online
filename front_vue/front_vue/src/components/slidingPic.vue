<template>
  <div class="sliding-pictures">
    <div class="vimg">
      <canvas id="sliderBlock"></canvas>
      <canvas id="codeImg"></canvas>
    </div>
    <div class="slider">
      <div class="track" :class="{ pintuTrue: puzzle }">
        {{ tips }}
      </div>
      <div class="button el-icon-s-grid" @mousedown.prevent="drag"></div>
    </div>
    <div class="operation">
          <span
            title="关闭验证码"
            @click="visible = false"
            class="el-icon-circle-close"
          ></span>
      <span
        title="刷新验证码"
        @click="canvasInit"
        class="el-icon-refresh-left"
      ></span>
    </div>
  </div>
</template>

<script>
    export default {
      name: "slidingPic",
      data(){
        return{
          tips:this.$t('tip.slidingPic'),
          visible:false,
          //滑块x轴数据
          slider: {
            mx: 0,
            bx: 0
          },
          //拼图是否正确
          puzzle: false,
        }
      }

    }
</script>

<style lang="scss" scoped>

</style>
