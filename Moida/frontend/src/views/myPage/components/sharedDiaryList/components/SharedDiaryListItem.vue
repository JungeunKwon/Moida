<template>
	<div @click="$router.push(`/shared/${item.id}`)" class="sharedDiaryItem">
		<div id="detailImgDiv">
			<img id="detailImg" :src="item.imgUrl" />
		</div>
		<div id="diaryInfo" class="diaryInfo">
			<div id="subjectDiv">
				<div id="roomId">{{ item.id }}</div>
				<div id="roomSubject">{{ item.subject }}</div>
			</div>
			<div id="hostDiv">
				<div id="hostName">{{ item.hostNickname }}</div>
				<img id="hostIcon" :src="item.hostProfileImg" />
			</div>
			<div style="clear: both;" />
			<div id="desc">{{ item.description }}</div>
		</div>
	</div>
</template>

<script>
import { mapActions } from "vuex";
export default {
	name: "SharedDiaryListItem",
	props: { item: {} },
	data() {
		return {};
	},
	mounted() {},
	computed: {},
	methods: {},
};
</script>

<style lang="scss">
.sharedDiaryItem {
	overflow: hidden;
	width: 100%;
	margin-bottom: 20px;
	border-radius: 5px;
	background-color: rgb(255, 255, 242);
	/* border: 1px solid rgba(192, 192, 192, 0.363); */
	box-shadow: 1px 1px 7px rgba(192, 192, 192, 0.589);

	&:hover {
		cursor: pointer;
		transition: 0.3s ease-in-out;
		filter: brightness(80%);
	}

	#detailImgDiv {
		float: left;
		width: 25%;
		height: 100px;
		overflow: hidden;
	}
	#detailImg {
		object-fit: cover;
	}
	.diaryInfo {
	}
	#diaryInfo {
		padding: 10px;
		text-align: left;
		float: right;
		width: 75%;
	}

	#desc {
		height: 50px;
		font-size: 12px;

		overflow: hidden;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 2; /* 라인수 */
		-webkit-box-orient: vertical;
		word-wrap: break-word;
		line-height: 12px;
		height: 24px;
	}

	#subjectDiv {
		font-weight: 400;
		line-height: 20px;
		margin-right: 2px;
	}

	#roomId {
		float: left;
		padding: 1px 3px 1px 3px;
		border-radius: 7px;
		font-size: 12px;
		color: rgb(182, 136, 66);
		/* color: rgb(100, 100, 100); */
		margin-right: 10px;
		line-height: 20px;
		/* border: 1px solid silver; */
		box-shadow: 0.5px 0.5px 3px rgb(218, 218, 218);
	}

	#roomSubject {
		text-overflow: ellipsis;
		white-space: nowrap;
		overflow: hidden;
		line-height: 20px;
	}

	#hostDiv {
		display: inline-block;
		width: 100%;
		height: 20px;
		padding-bottom: 5px;
	}

	#hostIcon {
		float: right;
		height: 20px;
		width: 20px;
		object-fit: cover;
		border-radius: 50%;
		border: 1px solid silver;
		margin-top: 2.5px;
	}

	#hostName {
		float: right;
		margin: 2px 0 0 3px;
		font-size: 13px;
	}
}
</style>
