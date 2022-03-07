import { createRouter, createWebHashHistory } from "vue-router";

// import Home from "../pages/Home.vue";
// import About from "../pages/About.vue";

// 配置映射关系
const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  // 这个注释叫魔法注释，生成的名称就可以区分了
  {
    path: '/home', 
    name: "home",
    component: () => import(/* webpackChunkName: "home-chunk"*/"../pages/Home.vue"),
    meta: {
      // 自定义属性
    },
    children: [
      {
        path: "",
        redirect: "/home/message"
      },
      {
        path: "message",
        component: () => import("../pages/HomeMessage.vue")
      },
      {
        path: "shops",
        component: () => import("../pages/HomeShops.vue")
      }
    ]
  },
  {
    path: '/about',
    name: "about",
    component: () => import(/* webpackChunkName: "about-chunk"*/"../pages/About.vue")
  },
  {
    path: '/user/:username',
    name: "user",
    component: () => import(/* webpackChunkName: "about-chunk"*/"../pages/User.vue")
  },
  {
    // 加了最后那个* ，就会返回参数数组，以 / 分割
    path: '/:pathMatch(.*)*',
    component: () => import("../pages/NotFound.vue")
  },
  // {
  //   path: '/:pathMatch(.*)',
  //   component: () => import("../pages/NotFound.vue")
  // }
];

// 创建一个路由对象 router
const router = createRouter({
  routes: routes,
  history: createWebHashHistory()
});

export default router;