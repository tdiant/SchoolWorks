import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

import VuexPersistence from "vuex-persist";

Vue.use(Vuex);

const vuexLocal = new VuexPersistence({
  storage: window.localStorage,
});

export default new Vuex.Store({
  plugins: [vuexLocal.plugin],
  state: {
    isLogin: false,
    user: null,
  },
  getters: {
    isLogin: (state) => state.isLogin,
    user: (state) => state.user,
  },
  mutations: {
    userStatus(state, flag) {
      state.isLogin = flag;
    },
    userData(state, data) {
      console.log("push====");
      console.log(data);
      state.user = data;
      console.log(state.user);
    },
  },
  actions: {
    userLogin({ commit }, flag) {
      commit("userStatus", flag);
    },
    userLogout({ commit }) {
      commit("userStatus", false);
      localStorage.removeItem("loginFlag");
      axios.post("/api/account/logout");
    },
    refreshUserData({ commit }) {
      axios.get("/api/account/checkLogin", {}).then((data) => {
        if (data == null || data.data == null || data.data === "") {
          commit("userStatus", false);
          localStorage.removeItem("loginFlag");
          // this.$router.push("/");
        } else {
          console.log("test");
          console.log(data);
          commit("userData", data.data);
        }
      });
    },
  },
  modules: {},
});
