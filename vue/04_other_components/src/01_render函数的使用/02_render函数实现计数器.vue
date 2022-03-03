<script>
  import { h } from 'vue';

  export default {
    data() {
      return {
        counter: 10
      }
    },
    render() {
      return h("div", {class: "title"}, [
        h("h2", null, `当前计数： ${this.counter}`),
        h("button",{
          onclick: () => this.counter++
        },"+1"),
        h("button",{
          onclick: () => this.counter--
        },"-1"),

      ]);
    },
  }
</script>

<style scoped>

</style>