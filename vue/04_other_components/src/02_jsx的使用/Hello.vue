<script>
  export default {
    render() {
      return (
        <div>
          <p>Hello world</p>
          {this.$slots.default ? this.$slots.default() : <span>哈哈哈</span>}
        </div>
      )
    },
  }
</script>

<style scoped>

</style>