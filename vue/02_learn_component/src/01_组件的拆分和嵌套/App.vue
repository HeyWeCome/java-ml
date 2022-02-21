<template>
  <div id="app">
    <Header></Header>
    <Main></Main>
    <Footer></Footer>
  </div>
</template>

<script>
  import Header from './Header';
  import Main from './Main';
  import Footer from './Footer';

  export default {
    components: {
        Header,
        Main,
        Footer,
    },
    data() {
    }
}
</script>

<style lang="scss" scoped>

</style>