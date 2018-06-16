import {fetchSuccess} from '../actions/actions'


const url = 'https://api.github.com/users/';

export const sendRequest = (login)=>(dispatch) =>{
    return fetch(url+login)
        .then(res =>fetchSuccess(dispatch)(res.json()));
}
