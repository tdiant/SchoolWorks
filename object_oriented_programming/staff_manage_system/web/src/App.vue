<template>
  <div id="app">
    <NavBar />
    <div id="app_main">
      <router-view />
    </div>

    <footer class="app_footer">
      <p>员工管理系统</p>
      <p>2021-2021 - Powered by tdiant, Made by ❤.</p>
    </footer>
    
  </div>
</template>

<style>
#app_main {
  margin: 0 auto;
  padding: 10px;
  margin-left: 5%;
  width: 90%;
  margin-top:10px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  min-width: 1080px;
}

.app_footer{
  margin-top: 50px;
  color:gray;
  line-height:8px;
  clear: both;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script>

import NavBar from './components/NavBar.vue'

export default {
  components: {
    NavBar
  }

}
</script>
