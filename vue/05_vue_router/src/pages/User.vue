<template>
  <div>
    <h2>User：{{$route.params.username}}</h2>
    <h2>User：{{username}}</h2>
  </div>
</template>

<script>
  import { useRoute } from 'vue-router';

  export default {
    created() {
      // this.$route.params.username
    },
    setup() {
      const route = useRoute();
      const username = route.params.username;

      return{
        username
      }
    }
  }
</script>

<style scoped>

</style>