import {fetchSuccess} from '../actions/actions'


const url = 'https://api.github.com/users/';

export const sendRequest = (login)=>(dispatch) =>{
    return fetch(url+login)
        .then(res =>res.json())
        .then(json=>dispatch(fetchSuccess(json)));
}
