<template>
  <div>
    <h1>员工考勤情况</h1>
    <el-row>
      <el-card style="padding: 0 0 25px 0;">

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
              <p style="color:gray;font-size:14px;">今日出勤人数</p>
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
              <p style="color:gray;font-size:14px;">今日未出勤</p>
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
              <p style="color:gray;font-size:14px;">迟旷到人数</p>
            </div>
          </div>

        </div>

      </el-card>
    </el-row>

    <el-row>

      <el-card class="box_card">
        <div
          slot="header"
          class="clearfix"
        >
          <span>签到时刻</span>
        </div>
        <el-col :span="8">
          <el-time-picker
            arrow-control
            placeholder="任意时间点"
            style="width:80%; margin-right:10px;"
          >
          </el-time-picker>
          <el-button>提交修改</el-button>
        </el-col>
        <el-col :span="16">
          <p class="timeText1">00:00:00</p>
        </el-col>
      </el-card>

    </el-row>

    <el-row>

      <el-card class="box_card">
        <div
          slot="header"
          class="clearfix"
        >
          <span>异常信息</span>
        </div>
        
      </el-card>
    </el-row>
  </div>
</template>

<style scoped>
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
.box_card {
  margin-top: 30px;
  text-align: left;
  padding: 10px 0 10px 0;
}
.timeText1 {
  font-size: 36px;
  margin-top: 10px;
  text-align: center;
}
</style>

