<template>

  <div>
    <el-row>
      <el-page-header
        @back="goBack"
        content="账号设置"
      >
      </el-page-header>
    </el-row>
    <el-row style="padding:40px;">
      <el-card>
        <h1>{{user.realName}}</h1>
        <div style="line-height:0.5;color:rgb(107,107,107);">
          <p style="font-size:18px;">#{{user.id}} - {{user.job}}</p>
          <p>所属于 {{user.department}}</p>
        </div>
      </el-card>
    </el-row>
    <el-row style="padding: 0 40px 40px 40px;text-align:left;">
      <el-card>
        <div
          slot="header"
          class="clearfix"
        >
          <span>修改密码</span>
        </div>
        <div style="width:60%;margin:0 auto;">
          <el-form
            ref="form"
            :model="changePwdForm"
            label-width="80px"
          >
            <el-form-item label="原密码*">
              <el-input
                type="password"
                v-model="changePwdForm.oldPassword"
                show-password
              ></el-input>
            </el-form-item>
            <el-form-item label="新密码*">
              <el-input
                type="password"
                v-model="changePwdForm.newPassword"
                show-password
              ></el-input>
            </el-form-item>
            <el-form-item label="确认密码*">
              <el-input
                type="password"
                v-model="changePwdForm.checkPassword"
                show-password
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                type="primary"
                @click="onPwdChangeSubmit"
              >确认修改</el-button>
              <el-button @click="clearPwdChange">重新输入</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </el-row>
  </div>

</template>

<script>
export default {
  data() {
    return {
      changePwdForm: {
        oldPassword: "",
        newPassword: "",
        checkPassword: "",
      }
    };
  },
  methods: {
    goBack() {
      this.$router.push("/");
    },
    onPwdChangeSubmit() {
      this.$axios.post("/api/account/changePassword", {
        old: this.changePwdForm.oldPassword,
        new: this.changePwdForm.newPassword,
        check: this.changePwdForm.checkPassword
      }).then(data => {
        if (data == null || data.data == null || data.data === "" || data.data === "false") {
          this.$message.error("修改失败！");
        } else {
          this.$message.success("修改成功！");
        }
      })
    },
    clearPwdChange() {
      this.changePwdForm.oldPassword = "";
      this.changePwdForm.newPassword = "";
      this.changePwdForm.checkPassword = "";
    }
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  }
}
</script>
