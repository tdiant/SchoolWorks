<template>
  <div class="home">
    <el-row>
      <el-col :span="8">
        <el-card style="height:280px;">
          <img
            class="avatarImg"
            src="../assets/logo.png"
          >
          <h1 style="margin-top:-3px;">{{user.realName}}</h1>
          <p style="color:gray;font-size:18px;margin-top:-8px;"> #{{user.id}} - {{user.job}}</p>
          <router-link to="/account/settings">
            <el-button>账号设置</el-button>
          </router-link>
          <el-button @click="handleLogout">退出登录</el-button>
        </el-card>
      </el-col>
      <el-col :span="10">
        <el-card style="height:280px;border:0;box-shadow:0 0 0 0 rgb(0 0 0 / 10%);">
          <div style="margin:0 auto;width:550px;">

            <div class="briefDataCard">
              <div
                class="briefleft"
                style="background: #909399;"
              >
                <i class="el-icon-s-custom"></i>
              </div>
              <div class="briefRight">
                <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
                <p style="color:gray;font-size:14px;">员工总数</p>
              </div>
            </div>

            <div class="briefDataCard">
              <div
                class="briefleft"
                style="background: #67C23A;"
              >
                <i class="el-icon-s-claim"></i>
              </div>
              <div class="briefRight">
                <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
                <p style="color:gray;font-size:14px;">今日考勤人数</p>
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
                <p style="color:gray;font-size:14px;">待批审批</p>
              </div>
            </div>

            <div class="briefDataCard">
              <div
                class="briefleft"
                style="background: #409EFF;"
              >
                <i class="el-icon-s-help"></i>
              </div>
              <div class="briefRight">
                <p style="font-size:26px;margin-bottom:-15px;margin-top:15px;">233</p>
                <p style="color:gray;font-size:14px;">组织数量</p>
              </div>
            </div>

          </div>
        </el-card>

      </el-col>

      <el-col :span='6'>
        <el-card style="height:280px;">
          <p style="color:gray">当前时间</p>
          <p style="font-size:18px;margin-top:60px;margin-bottom:-25px;">{{time.year}}年{{time.month}}月{{time.day}}日</p>
          <p class="timeText1">{{time.hour}}:{{time.minute}}:{{time.second}}</p>
        </el-card>
      </el-col>
    </el-row>

    <!-- <el-row>

      <div style="margin-top:30px;">
        <el-card>
          <div style="text-align:left;font-size:20px;font-weight:600;">
            <p>快速发起一个事务</p>
          </div>
          <div>
            <el-select style="width:9%;float:left;margin-right:1%;">
              <el-option> 123 </el-option>
            </el-select>
            <el-input
              placeholder="请输入内容"
              style="float:left;width:83%;margin-bottom:30px;"
            ></el-input>
            <el-button
              type="primary"
              style="float:left;width:6%;margin-left:1%;"
            >提交</el-button>
          </div>
        </el-card>
      </div>

    </el-row> -->

    <el-row>
      <el-card style="margin-top:30px;">
        <div style="text-align:left;font-size:20px;font-weight:600;">
          <div style="float:left;">
            <p>公告板</p>
          </div>
          <div style="float:right;">
            <template v-if="this.user.role>=2">
              <router-link to="/board/create">
                <el-button
                  type="primary"
                  icon="el-icon-plus"
                  circle
                ></el-button>
              </router-link>
            </template>
          </div>
        </div>
        <el-table
          :data="boardData"
          :key="Math.random()"
        >
          <el-table-column
            prop="date"
            label="日期"
            width="180"
          >
          </el-table-column>
          <el-table-column
            prop="title"
            label="标题"
          >
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="100"
          >
            <template slot-scope="scope">
              <el-button
                @click="boardLineClick(scope.row)"
                type="text"
                size="small"
              >查看</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-card>
    </el-row>

  </div>
</template>

<script>



export default {
  name: 'Home',
  data() {
    return {
      intervalId: null,
      time: {
        year: 0,
        month: 0,
        day: 0,
        hour: 0,
        minute: 0,
        second: 0
      },
      boardData: []
    };
  },
  methods: {
    timeRefresh() {
      if (this.intervalId != null) return;
      this.intervalId = setInterval(() => {
        let date = new Date();
        this.time.year = date.getFullYear();
        this.time.month = date.getMonth();
        this.time.day = date.getDate();
        this.time.hour = date.getHours();
        this.time.minute = date.getMinutes();
        this.time.second = date.getSeconds();
      })
    },
    handleLogout() {
      this.$store.dispatch("userLogout");
      this.$router.push("/login");
    },
    refreshBoardData() {
      this.$axios.get("/api/board/getAll").then(data => {
        if (data == null || data.data == null || data.data == "") {
          this.boardData = [];
        } else {
          this.boardData = data.data;
          for (var i = 0; i < this.boardData.length; i++) {
            //更新日期
            this.boardData[i].date = this.boardData[i].createdTime.substring(0, 10);

          }
          console.log(this.boardData);
        }
      });
    },
    boardLineClick(row) {
      this.$alert(row.description, row.title, {
        confirmButtonText: "确定"
      });
      console.log(row);
    }
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  },
  created() {
    this.timeRefresh();
    this.refreshBoardData();
  },
  destroyed() {
    clearInterval(this.intervalId);
    this.intervalId = null;
  }
}
</script>

<style scpoed>
.avatarImg {
  width: 100px;
  border: 3px solid rgb(165, 165, 165);
  border-radius: 50%;
}

.briefDataCard {
  float: left;
  margin-left: 7px;
  margin-top: 22px;
  height: 88px;
  width: 250px;
  border: 1px solid #ebeef5;
  box-shadow: 0 2px 12px 0 rgb(0 0 0 / 10%);
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
  width: 140px;
  padding: 0 10px;
}
.timeText1 {
  font-size: 36px;
}
</style>
