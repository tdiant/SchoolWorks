import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import axios from "axios";

Vue.prototype.$axios = axios;
axios.defaults.headers.post["Content-Type"] = "application/json";

Vue.config.productionTip = false;

Vue.use(ElementUI);

//登录拦截判定
router.beforeEach((to, from, next) => {
  store.dispatch("refreshUserData");
  let loginFlag = localStorage.getItem("loginFlag");
  if (loginFlag === "isLogin") {
    // 已经登录了
    store.state.isLogin = true;
    next();
    // 已经登录了还来登录界面
    if (!to.meta.isLogin) {
      next({
        path: "/",
      });
    }
  } else {
    // 没有登录
    if (to.meta.isLogin) {
      next({
        path: "/login",
      });
    } else {
      next();
    }
  }
});

router.afterEach((route) => {
  window.scroll(0, 0);
});

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
