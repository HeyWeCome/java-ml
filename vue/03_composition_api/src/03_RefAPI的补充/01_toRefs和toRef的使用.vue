<template>
  <div>
    {{info.name}}-{{info.age}}
    {{age}}
    <button @click="changeAge">修改age</button>
  </div>
</template>

<script>
  // toRefs主要是将解构后的数据变成可响应式的
  import { reactive, toRefs, toRef } from 'vue';

  export default {
    setup(props) {
      const info = reactive({
        name: "heywecome",
        age: 18
      })

      // 1.toRefs: 将reactive对象中所有属性都转为ref，建立链接
      // let { name, age } = toRefs(info);
      // 2.toRef：对其中一个属性进行转换ref，建立链接
      let { name } = info;
      let age = toRef(info, "age"); // 注意不要加大括号，已经返回ref对象了

      const changeAge = () => {
        info.age++;
        age.value++;
      };

      return {
        info,
        name,
        age,
        changeAge
      }
    }
  }
</script>

<style scoped>

</style>