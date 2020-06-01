import {
    createSharedDiary,
    getSharedDiary,
    getSharedDiaryDetail
} from "@/api/sharedDiary";

const state = {};

const mutations = {

};

const actions = {
    getSharedDiary() {
        return new Promise((resolve, reject) => {
            getSharedDiary()
                .then(response => {
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                });
        });
    },
    createSharedDiary({
        commit
    }, diaryInfo) {
        const formData = new FormData();
        formData.append("uploadFile", diaryInfo.uploadFile);
        formData.append("subject", diaryInfo.subject);
        formData.append("limitUser", diaryInfo.limitUser);
        formData.append("isPrivate", diaryInfo.isPrivate);
        formData.append("description", diaryInfo.description);

        for (var key of formData.entries()) {
            console.log(key[0] + ", " + key[1]);
        } // 폼데이터 로그 출력법

        return new Promise((resolve, reject) => {
            createSharedDiary(formData)
                .then(response => {
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                });
        });
    },
    getSharedDiaryDetail(diaryId) {
        return new Promise((resolve, reject) => {
            getSharedDiaryDetail(diaryId)
                .then(response => {
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                })
        })
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions,
};