<template>
  <div>
    我是home，使用ref{{message}}

    title {{title}}
    <!-- 当我们在template模板中使用ref对象，它会自动进行解包，不用写counter.value，直接写counter -->
    counter {{counter}}
    如果把counter放进一个对象里面 {{info.counter}}
    <button @click="increment">点我加counter</button>
  </div>
</template>

<script>
  import { ref } from 'vue';

  export default {
    /**
     * @param {*} props 父组件传递过来的属性，注意props里面不能使用this
     * @param {*} context 包含三个属性attrs：所有非prop的attribute 
     *                              slots：父组件传递过来的插槽（这个在以渲染函数返回时会有作用） 
     *                              emit：组件内部需要发出事件时会使用emit，因为我们不能使用this，所有不能通过this.$emit发出事件
     */
    setup(props, {attrs, slots, emit}) {
      
      // counter变成一个ref的可响应式的引用
      let counter = ref(100);

      let info = {
        counter
      }
      // const state = reactive({
      //   counter: 100
      // })

      // 定义一个局部函数
      const increment = () => {
        counter.value++;
      }

      return {
        counter,
        info,
        increment
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>