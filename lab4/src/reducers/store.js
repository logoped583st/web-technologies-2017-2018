import {applyMiddleware, createStore} from "redux";
import {combineReducers} from 'redux'
import thunk from "redux-thunk";
import reducerUser from './reducerUser'
import reducerOrgs from './reducerOrgs'

const reduser = combineReducers({reducerUser,reducerOrgs})
const store = createStore(reduser, applyMiddleware(thunk));

export default store;