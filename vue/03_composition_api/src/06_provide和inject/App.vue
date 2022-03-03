<template>
  <div>
    我是APP里面的数据： {{counter}}
    <home></home>
    <button @click="increment">点击修改</button>
  </div>
</template>

<script>
  import { ref, provide, readonly } from 'vue';
  import Home from './Home.vue';

  export default {
    components: {
      Home
    },
    setup(props) {
      const name = ref("heyewecome");
      let counter = ref(100);

      const increment = () => {
        counter.value++;
      }

      // 通过readonly可以使得传递给子孙组件里面的数据是只读的，不可修改，单向数据流
      provide("name", readonly(name));
      provide("counter", readonly(counter));

      return {
        counter,
        increment
      }
    }
  }
</script>

<style scoped>

</style>