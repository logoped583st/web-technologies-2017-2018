import { call, put, all, takeLatest } from 'redux-saga/effects';
import {sendRequest} from '../requsets/Requests'
import {fetchUserSuccess} from '../actions/actions'

export const GET_USER_REQUEST = 'GET_USER_REQUEST';
export const GET_USER_SUCCESS = 'GET_USER_SUCCESS';

export function* fetchUser(action) {
    const user = yield call(sendRequest, action.username);
    yield put(fetchUserSuccess(user));
}

export function* watchFetchUser() {
    yield takeLatest(GET_USER_REQUEST, fetchUser);
}

export default function* rootSaga() {
    yield all([
        watchFetchUser()
    ])
}