<template>
  <div>
    <el-menu
      :default-active="$route.path"
      class="el-menu-demo"
      mode="horizontal"
      router
      v-if="$route.path!='/login'"
    >
      <el-menu-item
        index="title"
        disabled
        class="navbar_title"
        style="color:black;opacity: 1;cursor: auto;"
      >员工管理系统</el-menu-item>
      <el-menu-item index="/">首页</el-menu-item>
      <el-menu-item index="/staff">人员</el-menu-item>
      <el-menu-item index="/attend">考勤</el-menu-item>
      <el-menu-item index="/order">审批</el-menu-item>
      <el-menu-item index="/salary">薪酬</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.navbar_title {
  color: black;
  font-size: 18px;
  opacity: 1;
}
</style>
