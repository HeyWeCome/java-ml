<template>
  <div>
    HomeContent: {{userName}} {{age}} 名字长度：{{nameLength}}
  </div>
</template>

<script>
  export default {
    inject: ["userName", "age", "nameLength"]
  }
</script>

<style lang="scss" scoped>

</style>