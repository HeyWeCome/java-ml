<template>
  <div>
    我是home使用reactive{{message}}

    title {{title}}
    counter {{state.counter}}

    <button @click="increment">点我加counter</button>
  </div>
</template>

<script>
  import { reactive } from 'vue';

  export default {
    props: {
      message: {
        type: String,
        required: true
      }
    },
    /**
     * @param {*} props 父组件传递过来的属性，注意props里面不能使用this
     * @param {*} context 包含三个属性attrs：所有非prop的attribute 
     *                              slots：父组件传递过来的插槽（这个在以渲染函数返回时会有作用） 
     *                              emit：组件内部需要发出事件时会使用emit，因为我们不能使用this，所有不能通过this.$emit发出事件
     */
    setup(props, {attrs, slots, emit}) {
      console.log(props.message);

      const state = reactive({
        counter: 100
      })

      // 定义一个局部函数
      const increment = () => {
        state.counter++;
      }

      return {
        state,
        increment
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>