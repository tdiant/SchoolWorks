<template>
  <div>
    <h1>审批</h1>
    <el-row>
      <div class="orderControllerBar">
        <el-button
          icon="el-icon-plus"
          type="primary"
          circle
        ></el-button>
        <el-input
          style="width:500px;margin-left:30px; margin-right:30px;"
          v-model="searchKeywords"
          @input="onSearchTypeChanged()"
          placeholder="输入相关关键字以搜索相关内容"
        ></el-input>
        <el-radio-group
          v-model="searchType"
          @change="onSearchTypeChanged()"
        >
          <el-radio :label="1">我的提交</el-radio>
          <el-radio :label="2">待处理</el-radio>
          <el-radio :label="3">全部</el-radio>
        </el-radio-group>
        <el-checkbox
          style="margin-left:30px;"
          v-model="searchNoClosedCheck"
          @change="onSearchTypeChanged()"
        >仅查看待处理项目</el-checkbox>
      </div>
    </el-row>
    <el-row>
      <el-card style="margin-top:20px;">
        <el-table
          :data="ordersData"
          style="width: 100%"
        >
          <el-table-column
            prop="date"
            label="日期"
            width="180"
          >
          </el-table-column>
          <el-table-column
            prop="authorStaff"
            label="创建人"
            width="180"
          >
          </el-table-column>
          <el-table-column
            prop="title"
            label="标题"
          >
          </el-table-column>
          <el-table-column
            prop="status"
            label="状态"
            width="180"
          >
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="100"
          >
            <template slot-scope="scope">
              <el-button
                @click="handleClick(scope.row)"
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
  data() {
    return {
      searchType: 1,
      searchNoClosedCheck: true,
      searchKeywords: "",
      ordersData: []
    }
  },
  methods: {
    onSearchTypeChanged() {
      var url = "/api/order/";
      // if (this.user.role >= 2) {
      //   url += "findAll";
      // } else {
      if (this.searchType == 1) {
        url += "findMyselfPull";
      } else if (this.searchType == 2) {
        url += "findByDepartment";
      } else if (this.searchType == 3) {
        url += "findAll";
      }
      // }
      let noClosedTag = this.searchNoClosedCheck;
      this.$axios.get(url).then(data => {
        if (data == null || data.data == null || data.data === "") {
          this.ordersData = [];
        } else {
          this.ordersData = data.data;
          for (var i = 0; i < this.ordersData.length; i++) {
            this.ordersData[i].date = this.ordersData[i].createdDate.substring(0, 10);
            this.ordersData[i].status = this.ordersData[i].closed ? "已解决" : "待处理";
          }
          this.ordersData = this.ordersData.filter(x => {
            var flag = true
            if (noClosedTag && x.closed) return false;
            else if (this.searchKeywords !== "") {
              console.log(x);
              return (x.title.indexOf(this.searchKeywords) >= 0 || x.details.indexOf(this.searchKeywords) >= 0);
            } else return true;
          });
        }
      })
    },
    handleClick(row){
      this.$router.push("/order/details/" + row.id);
    }
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  },
  created() {
    setTimeout(() => {
      this.onSearchTypeChanged();
    }, 1000);
  }
}


</script>

<style scoped>
.orderControllerBar {
  border-radius: 12px;
  border: 2px solid rgb(204, 204, 204);
  padding: 20px 0px 20px 0px;
}
</style>