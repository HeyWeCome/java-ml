<template>
  <div>
    普通对象：{{readonlyInfo}}
    引用对象：{{readonnlyInfo2}}
    ref对象：{{readonnlyInfo3}}
    <button @click="updateState">点我修改状态</button>
  </div>
</template>

<script>
  import { reactive, ref,readonly } from 'vue';

  export default {
    /**
     * @param {*} props 父组件传递过来的属性，注意props里面不能使用this
     * @param {*} context 包含三个属性attrs：所有非prop的attribute 
     *                              slots：父组件传递过来的插槽（这个在以渲染函数返回时会有作用） 
     *                              emit：组件内部需要发出事件时会使用emit，因为我们不能使用this，所有不能通过this.$emit发出事件
     */
    setup(props, {attrs, slots, emit}) {
      
      // 1.普通对象
      const info = {name: "why"};
      const readonlyInfo = readonly(info);

      // 2.响应式对象，一般给子组件就传递这个
      const info2 = reactive({
        name: "why"
      })
      const readonnlyInfo2 = readonly(info2);

      // 3.响应式的对象ref
      const info3 = ref("why");
      const readonnlyInfo3 = readonly(info3);

      // 定义一个局部函数
      const updateState = () => {
        readonlyInfo.name = "heywecome";
        readonnlyInfo2.name = "heywecome";
        readonnlyInfo3.value = "kang"
      }

      return {
        readonlyInfo,
        readonnlyInfo2,
        readonnlyInfo3
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>