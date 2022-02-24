<template>
  <div>
    <!-- 绑定到元素上 -->
    <h2 ref="title">哈哈哈哈</h2>
    <button @click="btnClick">获取元素</button>

    <!-- 绑定到一个组件实例上 -->
    <nav-bar ref="navBar"></nav-bar>
  </div>
</template>

<script>
  import NavBar from "./NavBar.vue";
  export default {
    components: {
      NavBar
    },
    methods: {
      btnClick() {
        console.log(this.$refs.title);
        console.log(this.$refs.navBar);
        console.log(this.$refs.navBar.message);

        // $el
        console.log("$el", this.$refs.navBar.$el);
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>