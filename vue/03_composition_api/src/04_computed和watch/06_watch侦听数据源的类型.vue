<template>
  <div>
    <h2 ref="title">hhhhhhhhhh</h2>
    <button @click="changeData">ddd</button>
  </div>
</template>

<script>
  import { ref, watch, reactive } from 'vue';

  export default {
    setup(props) {
      const title = ref(null);

      const info = reactive({
        name: "heywecome",
        age: 18
      })

      // 1.侦听watch时，传入一个getter函数
      // watch(() => info.name, (newValue, oldValue) => {
      //   console.log("newValue", newValue, "oldValue:", oldValue);
      // })

      // 2.传入一个可响应对象：reactive对象/ref对象
      // 情况一：reactive对象获取到的newValue和oldValue本身都是reactive对象
      // watch(info, (newValue, oldValue) => {
      //   console.log("newValue", newValue, "oldValue:", oldValue);
      // })
      // 如果希望oldValue和newValue是一个普通对象
      watch(() => {
        // 对info做一个解构
        return {...info};
      }, (newValue, oldValue) => {
        console.log("newValue", newValue, "oldValue:", oldValue);
      })

      // 2.传入一个可响应对象：reactive对象/ref对象
      // 情况二：ref对象获取newValue和oldValue是我们value值本身
      const name = ref('why');
      watch(name, (newValue, oldValue) => {
        console.log("newValue", newValue, "oldValue", oldValue);
      })

      const changeData = () => {
        info.name = "sssss";
      }

      return {
        title,
        changeData
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>