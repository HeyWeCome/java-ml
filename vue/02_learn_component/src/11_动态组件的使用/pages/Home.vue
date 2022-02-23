<template>
  <div @click="divClick">
    Home: {{name}} -> {{age}}
  </div>
</template>

<script>
  export default {
    name: "home",
    props: {
      name: {
        type: String,
        default: ""
      },
      age: {
        type: Number,
        default: 18
      }
    },
    emits: ["pageClick"],
    methods: {
      divClick() {
        this.$emit("pageClick");
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>