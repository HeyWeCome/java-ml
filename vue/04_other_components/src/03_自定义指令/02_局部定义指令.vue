<template>
  <div>
    <input type="text" v-focus>
  </div>
</template>

<script>
  import { ref, onMounted } from 'vue';

  export default {
    // 局部指令
    // directives: {
    //   focus: {
    //     mounted(el, bindings, vnode, preVnode) {
    //       console.log("focus mounted");
    //       el.focus();
    //     },
    //   }
    // }
  }
</script>

<style lang="scss" scoped>

</style>