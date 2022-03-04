import { createApp } from 'vue'
import App from './04_teleport内置组件/App.vue'
import registerDirectives from './directives';

const app = createApp(App);
registerDirectives(app);

// 全局定义：自定义指令
app.directive("focus", {
  mounted(el, bindings, vnode, preVnode) {
    console.log("focus mounted");
    el.focus();
  }
});

app.mount('#app');
