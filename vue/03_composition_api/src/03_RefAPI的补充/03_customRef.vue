<template>
  <div>
    <input type="text" v-model="message"/>
    <h2>{{message}}</h2>
  </div>
</template>

<script>
  import { ref } from 'vue';
  import debounceRef from './hook/useDebounceRef';

  export default {
    setup(props) {
      const message = debounceRef("hello world");

      return {
        message
      }
    }
  }
</script>

<style scoped>

</style>