<template>
  <div>
    <h2>NavBar</h2>
    <button @click="getParentAndRoot">获取父组件和根组件</button>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        message: "我是NavBar中的信息"
      }
    },
    methods: {
      sayHello(){
        console.log("hello world");
      },
      getParentAndRoot(){
        console.log("parent:", this.$parent);
        console.log("root:", this.$root);
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>