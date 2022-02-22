<template>
  <div>
    HomeContent
    <home-body></home-body>
    <home-about></home-about>
  </div>
</template>

<script>
  // import HomeContent from "./HomeContent.vue"
  import HomeBody from "./HomeBody.vue"
  import HomeAbout from "./HomeAbout.vue"

  export default {
    components:{
      // HomeContent
      HomeBody,
      HomeAbout
    },

  }
</script>

<style lang="scss" scoped>

</style>