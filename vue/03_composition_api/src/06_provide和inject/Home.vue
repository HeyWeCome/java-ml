<template>
  <div>
    我是home组件：{{name}}- {{counter}}
    <button @click="homeIncrement">子组件里面修改</button>
  </div>
</template>

<script>
  import { inject } from 'vue';

  export default {
    setup(props) {
      const name = inject("name", "我是一个默认值");
      const counter = inject("counter");

      const homeIncrement = () => {
        counter.value++;
      };

      return {
        name,
        counter,
        homeIncrement
      }
    }
  }
</script>

<style scoped>

</style>