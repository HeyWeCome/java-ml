<template>
  <div>
    <home></home>
    <async-category></async-category>

    <!-- suspense提供两个插槽，default为默认显示内容，fallback为默认内容无法显示时候展示的内容 -->
    <suspense>
      <template #default>
        <async-category></async-category>
      </template>
      <template #fallBack>
        <loading></loading>
      </template>

    </suspense>

  </div>
</template>

<script>
  import { defineAsyncComponent } from 'vue';
  import Home from './Home.vue';
  import Loading from './Loading.vue';

  // 写法一
  // const AsyncCategory = defineAsyncComponent( () => import('./AsyncCategory.vue')); 

  // 写法二，可以传递进去更多的参数
  const AsyncCategory = defineAsyncComponent({
    loader: () => import('./AsyncCategory.vue'),
    loadingComponent: Loading,
    delay: 2000, // 显示loadingComponent组件之前，等待多长时间
    /**
     * err: 错误信息
     * retry: 函数，调用retry尝试重新加载
     * attempt: 记录尝试的次数
     */
    // onError: function(err, retry, attempts){
    // }
  });

  export default {
    components: {
      Home,
      AsyncCategory,
      Loading
    }  
  }
</script>

<style lang="scss" scoped>

</style>