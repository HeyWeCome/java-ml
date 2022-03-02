<template>
  <div>
    {{info}}
    <button @click="changeInfo">修改info</button>
  </div>
</template>

<script>
  // toRefs主要是将解构后的数据变成可响应式的
  import { ref, shallowRef, triggerRef } from 'vue';

  export default {
    setup(props) {
      // 通过shallowRef改变之后，改变info里面的单个属性不会触发响应式变化，只有改变整体才会变化
      const info = shallowRef({
        name: "heywecome",
        age: 18
      })

      const changeInfo = () => {
        info.value.name = "james";
        // 由于shallowRef不会触发响应式，所以我们手动触发改变
        triggerRef(info);
      };

      return {
        info,
        changeInfo
      }
    }
  }
</script>

<style scoped>

</style>