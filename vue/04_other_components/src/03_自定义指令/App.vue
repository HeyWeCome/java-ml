<template>
  <div>
    <!-- <input type="text" v-focus> -->
    <h2 v-format-time>{{timestamp}}</h2>
    <h2 v-format-time="'YYYY/MM/DD'">{{timestamp}}</h2>
    <h2 v-format-time>{{timestamp}}</h2>
    
    {{timestamp}}
  </div>
</template>

<script>
  import { ref, onMounted } from 'vue';

  export default {
    setup() {
      const timestamp = 1646380757;

      return {
        timestamp
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>