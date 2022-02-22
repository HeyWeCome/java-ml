<template>
  <div>
    <button @click="btnClick">按钮点击</button>
  </div>
</template>

<script>
  import emitter from "./utils/eventbus";

  export default {
    methods: {
      btnClick() {
        console.log("你号");
        emitter.emit("heywecome", {name:"heywecome", age:18})
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>