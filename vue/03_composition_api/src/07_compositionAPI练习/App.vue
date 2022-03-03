<template>
  <div>
    <h2>当前的数：{{counter}}</h2>
    <h2>当前的数*2：{{doubleCounter}}</h2>
    <button @click="increment">+1</button>
    <button @click="decrement">-1</button>
    <h2>{{data}}</h2>
    <button @click="changeData">修改data数据</button>

    <p class="content"></p>

    <div class="scroll">
      <div class="scroll-x">scrollX:{{scrollX}}</div>
      <div class="scroll-y">scrollY:{{scrollY}}</div>
    </div>

    <div class="mouse">
      <div class="mouse-x">mouse-x:{{mouseX}}</div>
      <div class="mouse-y">mouse-y:{{mouseY}}</div>
    </div>
  </div>
</template>

<script> 
  
  import {
    useCounter,
    useTitle,
    useScrollPosition,
    useMousePosition,
    useLocalStorage
  } from './hooks';

  export default {
    setup(props) {
      // 对counter进行的操作
      const { counter, doubleCounter, increment, decrement} = useCounter();

      // 对title进行的操作
      const titleRef = useTitle("我是康康");
      setTimeout(() => {
        titleRef.value = "kobe";
      }, 3000);

      // 滚动位置
      const { scrollX, scrollY } = useScrollPosition();

      // 鼠标位置
      const { mouseX, mouseY} = useMousePosition();

      // localStorage
      const data = useLocalStorage("info", {name: "heywecome", age: 20});
      const changeData = () => {
        data.value = "哈哈哈哈哈"
      }

      return {
        counter,
        doubleCounter,
        increment,
        decrement,
        // 滚动
        scrollX,
        scrollY,
        // 鼠标位置
        mouseX,
        mouseY,
        // localStorage
        data,
        changeData
      }

    }
  }
</script>

<style scoped>
  .content {
    width: 1000px;
    height: 4000px;
  }

  .scroll {
    position: fixed;
    right: 30px;
    bottom: 30px;
  }

  .mouse {
    position: fixed;
    right: 30px;
    bottom: 160px;
  }
</style>