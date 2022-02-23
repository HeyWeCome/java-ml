<template>
  <div>
    <button v-for="item in tabs" :key="item" @click="itemClick(item)" :class="{active: currentTab === item}">{{item}}</button>
    <!-- 动态组件的实现 -->
    <keep-alive include="home,about">
      <component v-bind:is="currentTab"
               name="heywecome"
               :age="23"
               @pageClick="pageClick"></component>
    </keep-alive>
    


    <!-- <component is="about"></component>
    <component is="category"></component> -->
    
    <!-- 点击按钮，切换动态组件 v-if
    <template v-if="currentTab === 'home'">
      <home></home>
    </template>
    <template v-else-if="currentTab === 'about'">
      <about></about>
    </template>
    <template v-if="currentTab === 'category'">
      <category></category>
    </template> -->
  </div>
</template>

<script>
  import Home from './pages/Home.vue';
  import About from './pages/About.vue';
  import Category from './pages/Category.vue';

  export default {
    components: {
      Home,
      About,
      Category
    },
    data() {
      return {
        tabs: ["home", "about", "category"],
        currentTab: "home"
      }
    },
    methods: {
      itemClick(item) {
        this.currentTab = item;
      },
      pageClick() {
        alert("page内部发生了点击")
      }
    }
  }
</script>

<style scoped>
.active {
  color: red;
}
</style>