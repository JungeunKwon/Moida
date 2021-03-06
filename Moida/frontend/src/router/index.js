import Vue from "vue";
import VueRouter from "vue-router";
import SharedDiaryList from "../views/SharedDiaryList/index.vue";
import SharedDiary from "../views/SharedDiary/index.vue";
import Login from "../components/Login.vue";
import SignUp from "../components/SignUp.vue";
import WriteDiary from "../views/Diary/writediary.vue";
import DetailDiary from "../views/Diary/detail.vue";
import EditDiary from "../views/Diary/edit.vue";
import Diary from "../views/Diary/index.vue";
import Chat from "../views/Chatting/index.vue";
Vue.use(VueRouter);

const routes = [
	{
		path: "/login",
		name: "Login",
		component: Login,
	},
	{
		path: "/signUp",
		name: "SignUp",
		component: SignUp,
	},
	{
		path: "/shared",
		name: "SharedDiaryList",
		component: SharedDiaryList,
	},
	{
		path: "/shared/:id",
		name: "SharedDiary",
		component: SharedDiary,
	},
	{
		path: "/diary",
		name: "Diary",
		component: Diary,
	},
	{
		path: "/writediary",
		name: "WriteDiary",
		component: WriteDiary,
	},
	{
		path: "/editdiary/:id",
		name: "EditDiary",
		component: EditDiary,
	},
	{
		path: "/detaildiary/:id",
		name: "DetailDiary",
		component: DetailDiary,
	},
	{
		path: "/chat",
		name: "Chat",
		component: Chat,
	},
	{
		path: "/",
		name: "Trash",
		component: () =>
			import(/* webpackChunkName: "trash" */ "../views/Trash/index.vue"),
	},
	{
		path: "/myPage/:nickname",
		name: "myPage",
		props: true,
		component: () => import("../views/myPage/index.vue"),
	},
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes,
});

export default router;
