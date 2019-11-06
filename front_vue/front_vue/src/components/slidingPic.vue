<template>
  <div class="slider_validate">
    <div class="slider_pic">
      <canvas id="back_img"></canvas>
      <canvas id="slider_block"></canvas>
    </div>
    <div class="sliding-bar">

    </div>
    <div class="sliding-option">

    </div>
  </div>
</template>

<script>
    export default {
      name: "slidingPic",
      data(){
        return{

        }
      },
      props:{

      },
      created(){
        this.sliderInit();
      },
      mounted(){

      },
      methods:{
        //拼图验证码初始化
        sliderInit(){
          this.draw()
        },
        draw(){
          var backImg = document.querySelector("#back_img");
          var context = backImg.getContext('2d')
          var img = new Image()
          img.src = "https://picsum.photos/300/200"
          img.onload = function() {
            context.drawImage(img, 0, 0, img.width, img.height);
          };
        }
      }
    }
</script>

<style lang="scss" scoped>

</style>
