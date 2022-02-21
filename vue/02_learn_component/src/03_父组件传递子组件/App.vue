<template>
  <div>
    <show-message title="哈哈哈哈" content="我是内容"></show-message>
    <show-message title="哈哈1哈哈" content="我是内容1"></show-message>
    <show-message :title=title :content=content></show-message>

    <multi-root-element id="aaaa"></multi-root-element>
  </div>
</template>

<script>
  import ShowMessage from "./ShowMessage.vue";
  import MultiRootElement from "./MultiRootElement.vue";

  export default {
    components:{
      ShowMessage,
      MultiRootElement
    },
    data(){
      return{
        title: "我是data的titlte",
        content: "我是data的content"
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>