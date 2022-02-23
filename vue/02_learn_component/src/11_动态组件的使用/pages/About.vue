<template>
  <div>
    About
    <button @click="counter++">{{counter}}</button>
  </div>
</template>

<script>

  export default {
    name: "about",
    data() {
      return {
        counter: 0
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>