<template>
  <div>
    <button @click="increment">{{counter}}</button>
    setup里面没有beforeCreated和created，这两个方法的操作都可以在setup里面做
  </div>
</template>

<script>
  import { ref, onMounted, onUpdated, onUnmounted } from 'vue';

  export default {
    setup(props) {
      const counter = ref(0);

      onMounted(() => {
        console.log("App Mounted");
      });

      onUpdated(() => {
        console.log("APp Updated")
      });

      const increment = () => {
        counter.value++;
      };

      return {
        counter,
        increment
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>