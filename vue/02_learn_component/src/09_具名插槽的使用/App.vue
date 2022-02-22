<template>
  <div>
    <nav-bar :slotName="slotName">
      <template v-slot:left>
        <button>左边的按钮</button>
      </template>

      <template v-slot:center>
        <h2>我是的标题</h2>
      </template>

      <template v-slot:right>
        <i>右边的i元素</i>
      </template>
      
      <template v-slot:[slotName]>
        <h2>why的内容</h2>
      </template>
      
      
    </nav-bar>
  </div>
</template>

<script>
  import NavBar from "./NavBar.vue";

  export default {
    components: {
      NavBar
    },
    data() {
      return {
        slotName: "heywecome"
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>