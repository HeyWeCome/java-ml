<template>
  <div>
    <h2>{{title}}</h2>
    <h3>{{content}}</h3>
  </div>
</template>

<script>
  export default {
    // props:['title', 'content'],
    props: {
      title: String,
      content: {
        type: String,
        required: true,
        default: "123"
      },
      // 对象或数组默认值必须从一个工厂函数中获取，不然的话指向的是同一个内存地址
      info: {
        type: Object,
        default(){
          return {name: "heywecome"}
        }
      }
    },
    data(){

    },
  }
</script>

<style lang="scss" scoped>

</style>