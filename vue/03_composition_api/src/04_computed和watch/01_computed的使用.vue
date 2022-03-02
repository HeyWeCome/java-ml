<template>
  <div>
    {{fullName}}
    <button @click="changeName">修改firstName</button>
  </div>
</template>

<script>
  import { ref, computed } from 'vue';

  export default {
    setup(props) {
      const firstName = ref("Kobe");
      const lastName = ref("Bryant");

      // 用法一，传入一个getter方法
      // computed的返回值是ref对象
      // const fullName = computed(() => firstName.value + lastName.value);

      // 用法二，传入一个对象，对象包含getter和setter
      const fullName = computed({
        get: ()=> firstName.value + " " + lastName.value,
        set(newValue){
          // fullName.value = 
          const names = newValue.split(' ');
          firstName.value = names[0];
          lastName.value = names[1];
        }
      });

      const changeName = () => {
        firstName.value = 'kkk';
      };

      return {
        fullName,
        changeName
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>