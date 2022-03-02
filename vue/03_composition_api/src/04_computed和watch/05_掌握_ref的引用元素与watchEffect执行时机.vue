<template>
  <div>
    <h2 ref="title">hhhhhhhhhh</h2>
  </div>
</template>

<script>
  import { ref, watchEffect } from 'vue';

  export default {
    setup(props) {
      const title = ref(null);

      watchEffect( () => {
        console.log(title.value);
      }, {
        // 等到挂载完成才执行
        flush: "post"
      })

      return {
        title
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>