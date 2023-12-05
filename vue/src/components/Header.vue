<template>
<div style="font-size: 12px; display: flex;line-height:60px;" :header-cell-class-name="headerBg">
  <div style="flex:1;font-size: 20px">
    <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
    <!--    //页签-->
    <div style="margin-button:30px ;display: inline-block; margin-left: 10px">
      <el-breadcrumb separator-class="el-icon-arrow-right" >
        <el-breadcrumb-item :to="item.path" v-for="item in paths">{{ item.name }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

  </div>
  <el-dropdown style="width: 70px ;cursor: pointer">
    <span>王小虎</span>
    <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item style="font-size: 14px; padding: 5px 0">个人信息</el-dropdown-item>
      <el-dropdown-item style="font-size: 14px; padding: 5px 0">退出</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapse:{
      type:Boolean,
      default:false
    },
    collapseBtnClass:{
      type:String,
      default:'el-icon-s-fold'
    }
  },
  data() {
    return {
      paths: [
        {
          name: "首页",
          path: "/"
        },
        {
          name: "用户管理",
          path: "/user"
        }
      ]
    }
  },
  created() {
    console.log(this.$router)
  }
}
</script>

<style>
  .headerBg {
    background-color: #42b983;
  }
</style>