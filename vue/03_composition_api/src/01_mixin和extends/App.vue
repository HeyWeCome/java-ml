<template>
  <div>
    我是mixin和extends
    <h2>{{message}}</h2>
    <button @click="foo">foo</button>
  </div>
</template>

<script>
import { demoMixin } from "./mixins/demoMixin"

  export default {
    mixins: [demoMixin],
    data() {
      return {
        message: "我是App里面的message"
      }
    },
  }
</script>

<style scoped>

</style>