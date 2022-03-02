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
        age: 18,
        friend: {
          name: "kobe"
        }
      })
      const name = ref('why');
      
      // 侦听器watch
      watch(() => {
        // 这里我想对对象里面的对象进行深度侦听，发现无法获取旧值；
        // 发现，需要侦听属性里面的旧值，就要对那个属性再解构一次，也就是里面的friend
        return ([{...info.friend}, {...info}]);
      }, (newInfo, oldInfo) => {
        console.log(newInfo, oldInfo);
      }, {
        deep: true,
        immediate: true
      })

      const changeData = () => {
        info.friend.name = "curry";
      }

      return {
        changeData
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>