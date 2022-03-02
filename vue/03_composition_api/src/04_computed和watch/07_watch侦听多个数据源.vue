<template>
  <div>
    <button @click="changeData">ddd</button>
  </div>
</template>

<script>
  import { ref, watch, reactive } from 'vue';

  export default {
    setup(props) {
      // 1. 定义可响应式的对象
      const info = reactive({
        name: "heywecome",
        age: 18
      })
      const name = ref('why');
      
      // 侦听器watch侦听多个数据源
      watch([() => ({...info}), name], ([newInfo, newName], [oldInfo, oldName]) => {
        console.log(newInfo, newName, oldInfo, oldName);
      })

      const changeData = () => {
        info.name = "sssss";
        name.value = "kangknag"
      }

      return {
        changeData
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>