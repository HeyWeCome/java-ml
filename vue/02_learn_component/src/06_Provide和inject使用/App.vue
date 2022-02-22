<template>
  <div>
    HomeContent
    <home-body></home-body>
  </div>
</template>

<script>
  // import HomeContent from "./HomeContent.vue"
  import HomeBody from "./HomeBody.vue"
  import { computed } from "vue"
  export default {
    components:{
      // HomeContent
      HomeBody
    },
    provide() {
      return{
        userName: "heywecome",
        age: 23,
        nameLength: computed( () => this.names.nameLength) // ref对象 .value 这样父组件更新时，子组件也会更新
      }
    },
    data() {
      return {
        name: ["a", "b", "c"]
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>