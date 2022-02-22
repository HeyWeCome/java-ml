<template>
  <div class="nav-bar"> 
    <div class="left">
      <slot name="left"></slot>
    </div>
    <div class="center">
      <slot name="center"></slot>
    </div>
    <div class="right">
      <slot name="right"></slot>
    </div>
    <div class="addition">
      <slot :name="slotName"></slot>
    </div>
  </div>
</template>

<script>
  export default {
    props: {
      slotName: String
    }
    // data() {
    //   return {
    //     bindName: "why"
    //   }
    // },
  }
</script>

<style scoped>
  .nav-bar {
    display: flex;
  }

  .left, .right, .center, .addition {
    height: 44px;
  }

  .left, .right, .addition {
    width: 80px;
    background-color: green;
  }

  .center {
    flex: 1;
    background-color: blue;
  }
</style>