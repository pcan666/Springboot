<template>
  <div class="home">
    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1', '3']"
                 background-color="rgb(48,65,86)" text-color="#fff" active-text-color="#ffd04b"
                 style="overflow-x: hidden ;min-height: 100%"
                 :collapse-transition="false"
                 :collapse="isCollapse"

        >
          <div style="height: 60px;line-height: 60px;text-align: center;">
            <img src="../assets/logo.png" style="width: 20px;position: relative;top: 5px;margin-right: 5px"/>
            <b style="color: white" v-show="logoTextShow">后台管理系统</b>
          </div>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>
              <span slot="title">导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>
              <span slot="title">导航三</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style=" font-size: 12px;display: flex">
          <div style="flex:1;font-size: 18px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>
          <el-dropdown style="width: 70px ;cursor: pointer">
            <span>王小虎</span>
            <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>

        <el-main>
          <div style="margin-button:30px">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
          </div>

          <div style="padding: 10px 0">
            <el-input style="width: 200px;" suffix-icon="el-icon-search" placeholder="请输入名称"
                      v-model="username"></el-input>
            <el-input style="width: 200px;" suffix-icon="el-icon-message" placeholder="请输入邮箱" class="ml-5"
                      v-model="email"></el-input>
            <el-input style="width: 200px;" suffix-icon="el-icon-position" placeholder="请输入地址" class="ml-5"
                      v-model="address"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button class="ml-5" type="warning" @click="reset">重置</el-button>
          </div>

          <div style="margin: 10px 0">
            <el-button type="primary" @click="handleAdd">新增<i class="el-icon-circle-plus-outline"
                                                              style="margin-left: 5px"></i></el-button>
            <el-button type="primary">导入<i class="el-icon-bottom" style="margin-left: 5px"></i></el-button>
            <el-button type="primary">导出<i class="el-icon-top" style="margin-left: 5px"></i></el-button>
            <el-button type="danger" @click="delBatch">批量删除<i class="el-icon-remove-outline"
                                                              style="margin-left: 5px"></i></el-button>
          </div>

          <el-table :data="tableData" stripe border header-cell-class-name="headBg"
                    @selection-change="handleSelectionChange">
            <el-table-column
                type="selection"
                width="55">
            </el-table-column>
            <el-table-column prop="id" label="ID" width="50">
            </el-table-column>
            <el-table-column prop="userName" label="用户名" width="140">
            </el-table-column>
            <el-table-column prop="nickName" label="昵称" width="120">
            </el-table-column>
            <el-table-column prop="email" label="电子邮箱" width="200">
            </el-table-column>
            <el-table-column prop="phone" label="手机号码" width="200">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column label="操作" width="200">
              <template slot-scope="scope">
                <el-button type="warning" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"
                                                                              style="margin-left: 5px"></i></el-button>
                <el-button type="danger" @click="openDelMessageBox(scope.row.id)">删除<i class="el-icon-remove-outline"
                                                                                       style="margin-left: 5px"></i>
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2,5,10,20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
          </div>

          <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">
            <el-form label-width="80px" size="small">
              <el-form-item label="用户名:">
                <el-input v-model="form.userName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="昵称:">
                <el-input v-model="form.nickName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱:">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="手机号码:">
                <el-input v-model="form.phone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址:">
                <el-input v-model="form.address" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="save">确 定</el-button>
            </div>
          </el-dialog>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import request from "@/utils/request";

export default {
  name: 'HomeView',
  data() {

    return {
      username: '',
      email: '',
      address: '',
      dialogFormVisible: false,
      form: {},
      tableData: [],
      multipleSelection: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      logoTextShow: true,//默认显示
      sideWidth: 200,
    }
  },
  methods: {
    load() {
      //请求分页查询数据
      /*  fetch方式
      fetch("http://localhost:9090/user/page?" +
          "pageNum=" + this.pageNum + "&pageSize=" + this.pageSize + "&username=" + this.username +
          "&email=" + this.email + "&address=" + this.address
      )
          .then(res => res.json()).then(res => {
        console.log(res)
        this.tableData = res.data;
        this.total = res.total;
      });*/
      //request方式
      request.get("/user/page", {
            params: {
              pageNum: this.pageNum,
              pageSize: this.pageSize,
              username: this.username,
              email: this.email,
              address: this.address,
            }
          }
      ).then(res => {
        console.log(res);
        this.tableData = res.records;
        this.total = res.total;
      })
    },
    save() {
      request.post("/user/save", this.form).then(res => {
        if (res) {
          this.$message.success("保存成功")
          this.dialogFormVisible = false;
          this.load();
        } else {
          this.$message.error("保存失败")
        }
      })
    },
    reset() {
      this.username = '';
      this.email = '';
      this.address = '';
      this.load();
    },
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
    handleSizeChange(pageSize) {
      console.log(pageSize)
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum)
      this.pageNum = pageNum;
      this.load();
    },
    handleAdd() {
      this.dialogFormVisible = true;
      this.form = {}
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogFormVisible = true
    },
    del(id) {
      request.delete("/user/delete/" + id).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.dialogFormVisible = false;
          this.load();
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    openDelMessageBox(id) {
      this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }).then(() => {
        request.delete("/user/delete/" + id);
        this.load()
        this.$message({//Argument types do not match parameters
              type: 'success',
              message: '删除成功!'
            },
            // location.reload()
        )
        ;
      }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          },
      );
    },
    handleSelectionChange(val) {
      console.log(val)
      this.multipleSelection = val;
    },
    delBatch() {
      this.$confirm('确认批量删除这些数据吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }).then(() => {
        //批量删除逻辑
        let ids = this.multipleSelection.map(v => v.id);
        request.post("/user/delete/batch", ids);
        this.load()

        this.$message({
              type: 'success',
              message: '批量删除成功!'
            },
        );
      }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消批量删除'
            });
          },
      );
      /////////////////
    },
  },

  created() {
    this.load();
  },
}
</script>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}

.headBg {
  background-color: #eee !important;
}
</style>
