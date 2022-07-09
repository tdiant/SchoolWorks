<template>

  <div>
    <el-row>
      <el-page-header
        @back="goBack"
        content="新建公告"
      >
      </el-page-header>
    </el-row>
    <el-row style="padding: 40px 40px 40px 40px;text-align:left;">
      <el-card>
        <div
          slot="header"
          class="clearfix"
        >
          <span>公告内容</span>
        </div>
        <div style="width:60%;margin:0 auto;">
          <el-form
            ref="form"
            :model="changePwdForm"
            label-width="80px"
          >
            <el-form-item label="标题*">
              <el-input v-model="boardForm.title"></el-input>
            </el-form-item>
            <el-form-item label="内容*">
              <el-input
                type="textarea"
                :rows="10"
                v-model="boardForm.description"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                type="primary"
                @click="onSubmit"
              >提交</el-button>
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
      boardForm: {
        title: "",
        description: ""
      }
    };
  },
  methods: {
    goBack() {
      this.$router.push("/");
    },
    onSubmit() {
      this.$axios.post("/api/board/create", {
        title: this.boardForm.title,
        description: this.boardForm.description
      }).then(data => {
        if (data == null || data.data == null || data.data === "" || data.data === "false") {
          this.$message.error("创建失败！");
        } else {
          this.$message.success("创建成功！");
        }
      })
    }
  },
  computed: {
    user() {
      return this.$store.getters.user;
    }
  }
}
</script>
