import {fetchSuccess} from '../actions/actions'
import {fetchSuccessOrg} from '../actions/actions'


const urlUserInfo = 'https://api.github.com/users/';
const urlOrgsUser = "https://api.github.com/users/"

export const sendRequest = (login)=>(dispatch) =>{
    return fetch(urlUserInfo+login)
        .then(res =>res.json())
        .then(json=>dispatch(fetchSuccess(json)));
}

export const sendRequestOrgs = (login) =>(dispatch)=>{
    return fetch(urlOrgsUser+login+"/orgs")
        .then(res =>res.json())
        .then(json=>dispatch(fetchSuccessOrg(json)))
    
}
