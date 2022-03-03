<template>
  <div>
    {{counter}}
    <hello message="nihao" @increment="getCounter"></hello>
  </div>
</template>

<script setup>
  import { ref } from 'vue';
  import Hello from './Hello.vue';

  const counter = ref(0);
  const increment = () => {
    counter.value++;
  }

  const getCounter = (payload) => {
    console.log(payload);
  }
</script>

<style lang="scss" scoped>

</style>