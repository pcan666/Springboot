<template>
  <div class="home">
    <el-container style="min-height: 100vh">

      <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246)">
        <Aside :logoTextShow="logoTextShow" :isCollapse="isCollapse"/>
      </el-aside>

      <el-container>
        <el-header style="border-bottom: 1px solid #cccccc;">
          <Header :collapseBtnClass="collapseBtnClass" :collapse="collapse"/>
        </el-header>

        <el-main>
          <!--          表示当前页面的子路由会在router-view中展示（子路由在router包下的children属性中）-->
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src

import Aside from "@/components/Aside";
import Header from "@/components/Header";
import User from "@/views/User";
// import request from "@/utils/request";

export default {
  name: 'HomeView',
  components: {
    Header,
    Aside,
    User,
  },
  data() {

    return {
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      logoTextShow: true,//默认显示
      sideWidth: 200,
    }
  },
  methods: {

    //点击收缩按钮触发
    collapse() {
      this.isCollapse = !this.isCollapse//取反
      if (this.isCollapse) {//如果收缩
        this.sideWidth = 64 /*Unused definition sideWidth*/
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      } else {//如果伸展
        this.collapseBtnClass = 'el-icon-s-fold'
        this.sideWidth = 200
        this.logoTextShow = true
      }
    },
  }
}
</script>

<style>

</style>
