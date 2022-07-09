<template>
  <div>
    <el-row>
      <h1>人员列表</h1>
    </el-row>
    <el-row>
      <el-card>
        <el-input
          placeholder="请输入姓名、工号、岗位或其他关键字，以搜索目标员工"
          style="width:90%;margin-right:20px;"
        ></el-input>
        <el-button
          icon="el-icon-search"
          type="primary"
          circle
        ></el-button>
        <el-button
          icon="el-icon-plus"
          circle
        ></el-button>
      </el-card>
    </el-row>
    <el-row>

      <el-card class="staffListMain">
        <el-table
          :data="tableData"
          style="width: 100%"
        >
          <el-table-column
            prop="id"
            label="员工号"
            width="180"
          >
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="180"
          >
          </el-table-column>
          <el-table-column
            prop="department"
            label="部门"
          >
          </el-table-column>
          <el-table-column
            prop="job"
            label="岗位"
          >
          </el-table-column>
          <el-table-column
            prop="progress"
            label="操作"
          >
          </el-table-column>
        </el-table>
      </el-card>

    </el-row>
  </div>
</template>

<style scoped>
.staffListMain {
  margin-top: 20px;
}
</style>
