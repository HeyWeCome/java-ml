<template>
  <div>
    <show-names :names="names">
      <template v-slot:heywecome="slotProps">
        <button>{{slotProps.item}}-{{slotProps.index}}</button>
      </template>
    </show-names>

    <!-- 默认插槽的省略写法：独占默认插槽的缩写。如果有其他的具名插槽，不能这样写，必须要template-->
    <show-names :names="names" v-slot="slotProps">
      <button>{{slotProps.item}}-{{slotProps.index}}</button>
    </show-names>

    <show-names :names="names">
      <template #heywecome="slotProps">
        <h1>{{slotProps.item}}-{{slotProps.index}}</h1>
      </template>
    </show-names>
  </div>
</template>

<script>
  // import ChildCpn from "./ChildCpn.vue";
  import ShowNames from "./ShowNames.vue";

  export default {
    components: {
      // ChildCpn,
      ShowNames
    },
    data() {
      return {
        names: ['heywecome', 'james', 'curry']
      }
    },
  }
</script>

<style lang="scss" scoped>

</style>