<template>
  <div>
    <h2>{{name}}</h2>
    <h2>{{age}}</h2>
    <button @click="changeName">修改Name</button>
    <button @click="changeAge">修改Age</button>
  </div>
</template>

<script>
  import { ref, watchEffect } from 'vue';

  export default {
    setup(props) {
      // watchEffect会自动收集响应式依赖
      const name = ref("heywecome");
      const age = ref(18);

      const changeName = () => {
        name.value = "kangkang";
      };

      const changeAge = () => {
        age.value++;

        if(age.value > 25){
          stop();
        }
      }

      // 一开始就会默认执行一次
      const stop = watchEffect(() => {
        console.log("name", name.value);
        console.log(age.value);
      })

      return {
        name,
        age,
        changeName,
        changeAge
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>