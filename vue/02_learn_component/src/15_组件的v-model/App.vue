<template>
  <div>
    <!-- <input v-model="message">
    <h2>{{message}}</h2> -->

    <!-- 组件上使用v-model -->
    <my-input v-model="message"></my-input>
    <my-input :modelValue="message" @update:model-value="message = $event"></my-input>
    <h2>{{message}}</h2>
  </div>
</template>

<script>
  import MyInput from "./MyInput.vue"
  export default {
    components: {
      MyInput
    },
    data() {
      return {
        message: "你好"
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>