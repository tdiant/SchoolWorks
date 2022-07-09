<template>

  <div>
    <el-row>
      <el-page-header
        @back="goBack"
        content="审批详情"
      >
      </el-page-header>
    </el-row>
    <el-row style="padding: 40px 40px 40px 40px;text-align:left;">
      <el-card>
        <div
          slot="header"
          class="clearfix"
          style="font-size:24px;"
        >
          <span>[{{this.orderData.closed?"已解决":"待处理"}}] {{orderData.title}}</span>
        </div>
        <div style="width:90%;margin:0 auto;font-size:18px;">
          <el-card style="color:gray;line-height:0.7;">
            <p>作者: {{this.orderData.authorStaff}}</p>
            <p>时间: {{this.orderData.createdDate}}</p>
          </el-card>
          <el-card>
            <p>{{this.orderData.details}}</p>
          </el-card>
        </div>
      </el-card>
    </el-row>
    <el-row style="padding: 0 40px 40px 40px;text-align:left;">
      <!-- 有权限且未处理 -->
      <template v-if="this.user.role>=1 && !this.orderData.closed">
        <el-card>
          <div
            slot="header"
            class="clearfix"
          >
            <span>回复</span>
          </div>
          <div>
            <el-input
              type="textarea"
              :rows="10"
              placeholder="请输入内容"
              v-model="orderResponseDetails"
            >
            </el-input>
            <el-button
              @click="submitResponse"
              type="primary"
            >提交</el-button>
          </div>
        </el-card>
      </template>

      <!-- 已经处理了 -->
      <template v-if="this.orderData.closed">
        <el-card>
          <div
            slot="header"
            class="clearfix"
          >
            <span>回复</span>
          </div>
          <div>
            <el-card style="color:gray;line-height:0.7;">
              <p>处理人: {{this.orderData.responseStaff}}</p>
              <p>处理时间: {{this.orderData.responseDate}}</p>
            </el-card>
            <el-card>
              <p>{{this.orderData.responseDetails}}</p>
            </el-card>
          </div>
        </el-card>
      </template>

    </el-row>
  </div>

</template>

<script>
export default {
  data() {
    return {
      orderData: {
        title: "加载中"
      },
      orderResponseDetails: ""
    };
  },
  methods: {
    goBack() {
      window.history.back();
    },
    submitResponse() {
      this.$axios.post("/api/order/responseOrder", {
        id: this.orderData.id,
        details: this.orderResponseDetails,
      }).then(data => {
        if (data == null || data.data == null || data.data === "" || data.data === "false" || data.data == false) {
          this.$message.error("提交错误");
        } else {
          this.$message.success("提交成功！");
          this.$router.push("/order");
        }
      })
    }
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  },
  created() {
    let id = this.$route.params.id;
    this.$axios.get("/api/order/getOrder?id=" + id)
      .then(data => {
        if (data == null || data.data == null || data.data === "") {
          this.orderData = {
            title: "加载失败"
          };
        } else {
          this.orderData = data.data;

        }
      });
  },
}
</script>
