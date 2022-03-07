<template>
  <div>
    <router-link to="/home">首页</router-link>
    <router-link to="/about">关于</router-link>
    <router-link to="/user/heywecome">用户</router-link>
    <!-- <router-link :to="'/user/'+heywecome">用户</router-link> -->
    <router-view></router-view>

    <button @click="jumpToHome">跳转至关于,普通methods</button>
    <button @click="jumpToAbout">关于, compositionAPI实现</button>
  </div>
</template>

<script>
  import {useRouter} from 'vue-router';

  export default {
    methods: {
      jumpToHome() {
        // 跳转之前拿到router对象
        this.$router.push("/about");
      }
    },
    setup() {
      const router = useRouter();

      const jumpToAbout = () => {
        // useRouter.push("/about")
        router.push({
          path: "/about",
          query: {
            name: "heywcome",
            age: 23
          }
        })
      }

      return {
        jumpToAbout
      }
    }
  }
</script>

<style scoped>
  .router-link-active{
    color: brown;
  }
</style>