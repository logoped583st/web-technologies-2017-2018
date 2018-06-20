import { createStore, applyMiddleware } from 'redux';
import createSagaMiddleware, { END } from 'redux-saga';
import { combineReducers } from 'redux';

import reducerUser from '../reducers/ReducerUser';
import reducerOrgs from '../reducers/ReducerOrgs'
import reduserRepos from '../reducers/ReducerRepos'
import reduserFollowers from '../reducers/ReducerFollowers'
import rootSaga from '../actions/saga';

const redusers = combineReducers({reducerUser,reducerOrgs,reduserFollowers,reduserRepos})

export default () => {
    const sagaMiddleware = createSagaMiddleware();
    const store = createStore(redusers, applyMiddleware(sagaMiddleware));

    sagaMiddleware.run(rootSaga);
    store.runSaga = () => sagaMiddleware.run(rootSaga);
    store.close = () => store.dispatch(END);

    return store;
};