export const demoMixin = {
  data() {
    return {
      message: "Hello DemoMixin"
    }
  },
  methods: {
    foo() {
      console.log("demo minxin foo");
    }
  },
  created() {
    console.log("我是created混入")
  },
}