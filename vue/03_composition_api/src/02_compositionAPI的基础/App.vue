<template>
  <div>
    <home message="你好"></home>
    <home-ref></home-ref>
    <home-read-only></home-read-only>
  </div>
</template>

<script>
  import Home from "./Home.vue";
  import HomeRef from "./HomeRef.vue";
  import HomeReadOnly from "./HomeReadOnly.vue";

  export default {
    components: {
      Home,
      HomeRef,
      HomeReadOnly
    },
    setup(props) {
      
    }
  }
</script>

<style lang="scss" scoped>

</style>