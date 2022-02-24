<template>
  <div>
    <h2>{{message}}</h2>
    <button @click="changeMessage">修改</button>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        message: "heelo"
      }
    },
    methods: {
      changeMessage() {
        this.message = "gogogo";
      }
    },
    beforeCreate() {
      console.log("home beforeCreate");
    },
    created() {
      console.log("home created");
    },
    beforeMount() {
      console.log("home beforeMount");
    },
    mounted() {
      console.log("home mounted");
    },
    beforeUnmount() {
      console.log("home beforeUnmount");
    },
    unmounted() {
      console.log("home unmounted");
    },
    beforeUpdate() {
      console.log("home beforeUpdate");
    },
    updated() {
      console.log("home updated");
    },
  }
</script>

<style lang="scss" scoped>

</style>