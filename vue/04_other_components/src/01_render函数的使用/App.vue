<script>
  import { ref, h } from 'vue';
  import HelloWorld from './HelloWorld.vue'

  export default {
    render() {
      return h(HelloWorld, {}, {
        default: props => h("span", null, "app传入到HelloWorld中的内22容")
      });
    }
  }
</script>

<style scoped>

</style>