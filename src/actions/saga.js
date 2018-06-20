import { call, put, all, takeLatest } from 'redux-saga/effects';
import * as actions from './actions'
import * as request from '../requsets/Requests'
import * as constants from '../Constants'


export function* fetchUser(action) {
    const user = yield call(request.sendRequest, action.username);
    yield put(actions.fetchUserSuccess(user));
}

export  function* fetchOrgs(action){
    const orgs = yield call(request.sendRequestOrgs,action.username)
    yield put(actions.fetchOrgsSuccess(orgs));
}


export  function* fetchRepos(action){
    const repos = yield call(request.sendRequestRepos,action.username)
    yield put(actions.fetchReposSuccess(repos));
}

export  function* fetchFollowers(action){
    
    const followers = yield call(request.sendRequestFollowers,action.username)
    console.log(followers);
    yield put(actions.fetchFollowersSuccess(followers));
}

export function* watchFetchUser() {
    yield takeLatest(constants.GET_USER_REQUEST, fetchOrgs);
}

export function* watchFetchOrgs() {
    yield takeLatest(constants.GET_USER_REQUEST, fetchUser);
}

export function* watchFetchRepos() {
    yield takeLatest(constants.GET_REPOS_REQUEST, fetchRepos);
}

export function* watchFetchFollowers() {
    yield takeLatest(constants.GET_FOLLOWERS_REQUEST, fetchFollowers);
}

export default function* rootSaga() {
    yield all([
        watchFetchUser(),
        watchFetchOrgs(),
        watchFetchFollowers(),
        watchFetchRepos()
    ])
}