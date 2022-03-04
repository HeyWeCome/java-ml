<template>
  <div>
    <teleport to="#hello">
      <HelloWorld></HelloWorld>
    </teleport>
    
  </div>
</template>

<script>
  import HelloWorld from "./HelloWorld.vue";
  export default {
    component: {
        HelloWorld
    },
    components: { HelloWorld }
}
</script>

<style scoped>

</style>