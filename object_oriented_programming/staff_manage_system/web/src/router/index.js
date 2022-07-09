import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import StaffList from "../views/staff/StaffList.vue";
import StaffPerson from "../views/staff/StaffPerson.vue";
import AttendMain from "../views/attend/AttendMain.vue";
import OrderMain from "../views/order/OrderMain.vue";
import SalaryMain from "../views/salary/SalaryMain.vue";
import Login from "../views/account/Login.vue";
import AccountSettings from "../views/account/AccountSettings.vue";
import BoardCreate from "../views/board/BoardCreate.vue";
import OrderDetails from "../views/order/OrderDetails.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/staff",
    name: "Staff List",
    component: StaffList,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/staff/person",
    name: "Staff Person",
    component: StaffPerson,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/attend",
    name: "Attendance",
    component: AttendMain,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/order",
    name: "Order",
    component: OrderMain,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/salary",
    name: "Salary",
    component: SalaryMain,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
    meta: {
      isLogin: false,
    },
  },
  {
    path: "/account/settings",
    name: "Account Settings",
    component: AccountSettings,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/board/create",
    name: "Board Create",
    component: BoardCreate,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/order/details/:id",
    name: "Order Details",
    component: OrderDetails,
    meta: {
      isLogin: true,
    },
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
