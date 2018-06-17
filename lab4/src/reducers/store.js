import {applyMiddleware, createStore} from "redux";
import {combineReducers} from 'redux'
import thunk from "redux-thunk";
import reducerUser from './ReducerUser'
import reducerOrgs from './ReducerOrgs'
import reducerTextArea from './ReducerTextArea'

const reduser = combineReducers({reducerUser,reducerOrgs,reducerTextArea})
const store = createStore(reduser, applyMiddleware(thunk));

export default store;