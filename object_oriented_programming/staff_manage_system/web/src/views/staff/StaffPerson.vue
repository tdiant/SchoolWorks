<template>
  <div>
    <el-page-header content="员工详情">
    </el-page-header>
    <el-card class="staffMain">
      <img
        src="../../assets/logo.png"
        class="avatarImg"
      />
      <p class="staffName">张三</p>
      <p class="staffID">#1234567</p>
      <el-descriptions
        class="margin-top"
        title="员工基本信息"
        :column="3"
        :size="size"
        border
      >
        <template slot="extra">
          <el-button
            type="primary"
            size="small"
          >操作</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            用户名
          </template>
          kooriookami
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          18100000000
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            所属部门
          </template>
          运营维护部
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            备注
          </template>
          <el-tag size="normal">实习期</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            入职时间
          </template>
          2021-11-06
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            薪资水准
          </template>
          2000
        </el-descriptions-item>
      </el-descriptions>

      <el-card class="detailCard">
        <div
          slot="header"
          class="clearfix"
        >
          <span>员工工具</span>
        </div>
        <el-button>工资计算</el-button>
        <el-button>组织关系</el-button>
      </el-card>

      <el-card class="detailCard">
        <div
          slot="header"
          class="clearfix"
        >
          <span>考勤情况</span>
          <el-button
            style="float: right; padding: 3px 10px;"
            type="text"
          >查看详情</el-button>
        </div>

        <div style="margin:0 auto;margin-left:15%;height:1px;">

          <div class="briefDataCard">
            <div
              class="briefleft"
              style="background: #E6A23C;"
            >
              <i class="el-icon-s-order"></i>
            </div>
            <div class="briefRight">
              <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
              <p style="color:gray;font-size:14px;">本月出勤天数</p>
            </div>
          </div>

          <div class="briefDataCard">
            <div
              class="briefleft"
              style="background: #E6A23C;"
            >
              <i class="el-icon-s-order"></i>
            </div>
            <div class="briefRight">
              <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
              <p style="color:gray;font-size:14px;">迟旷到次数</p>
            </div>
          </div>

          <div class="briefDataCard">
            <div
              class="briefleft"
              style="background: #E6A23C;"
            >
              <i class="el-icon-s-order"></i>
            </div>
            <div class="briefRight">
              <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
              <p style="color:gray;font-size:14px;">请假次数</p>
            </div>
          </div>

        </div>

      </el-card>

      <el-card class="detailCard">
        <div
          slot="header"
          class="clearfix"
        >
          <span>审批情况</span>
          <el-button
            style="float: right; padding: 3px 10px;"
            type="text"
          >查看详情</el-button>
        </div>

        <div style="margin:0 auto;margin-left:15%;height:1px;">

          <div class="briefDataCard">
            <div
              class="briefleft"
              style="background: #E6A23C;"
            >
              <i class="el-icon-s-order"></i>
            </div>
            <div class="briefRight">
              <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
              <p style="color:gray;font-size:14px;">待批数量</p>
            </div>
          </div>

          <div class="briefDataCard">
            <div
              class="briefleft"
              style="background: #E6A23C;"
            >
              <i class="el-icon-s-order"></i>
            </div>
            <div class="briefRight">
              <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
              <p style="color:gray;font-size:14px;">待回应</p>
            </div>
          </div>

          <div class="briefDataCard">
            <div
              class="briefleft"
              style="background: #E6A23C;"
            >
              <i class="el-icon-s-order"></i>
            </div>
            <div class="briefRight">
              <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
              <p style="color:gray;font-size:14px;">不合格</p>
            </div>
          </div>

        </div>

      </el-card>

    </el-card>
  </div>
</template>

<style scoped>
.staffMain {
  margin-top: 30px;
}
.avatarImg {
  width: 120px;
  border: 2px solid rgb(165, 165, 165);
  border-radius: 50%;
}
.staffMain {
  line-height: 0.5;
}
.staffMain .staffName {
  font-size: 32px;
  font-weight: 600;
}
.staffMain .staffID {
  color: gray;
  font-size: 20px;
}
.staffMain .detailCard {
  margin-top: 20px;
  text-align: left;
  padding: 0 0 25px 10px;
}
.briefDataCard .briefleft {
  float: left;
  color: white;
  width: 88px;
  height: 100%;
  font-size: 40px;
}

.briefDataCard .briefleft i {
  margin-top: 20px;
}

.briefDataCard .briefRight {
  float: left;
  width: calc(90% - 88px);
}
.briefDataCard {
  margin: 0 auto;
  margin-left: 15px;
  height: 88px;
  width: 25%;
  border: 1px solid #ebeef5;
  box-shadow: 0 2px 12px 0 rgb(0 0 0 / 10%);
  line-height: 1.4;
  text-align: center;
  float: left;
}
</style>

