<template>
  <div>
  </div>
</template>

<script>
  import emitter from "./utils/eventbus";

  export default {
    created() {
      // 监听 heywecome 事件
      emitter.on("heywecome", (info) => {
        console.log(info);
      })
      // 监听所有事件
      emitter.on("*", (type, info) => {
        console.log("监听所有事件的结果为：", type, info);
      })
    },
  }
</script>

<style lang="scss" scoped>

</style>