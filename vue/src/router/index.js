import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manage.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '主页',
        component: () => import(/* webpackChunkName: "about" */ '../views/Manage'),
        children: [
            {
                path: 'home',
                name: '主页',
                component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')
            },
            {
                path: 'user',
                name: '用户管理',
                component: () => import(/* webpackChunkName: "about" */ '../views/User.vue')
            },

        ],
        // 重定向到home
        redirect: '/home',
    },
    {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
