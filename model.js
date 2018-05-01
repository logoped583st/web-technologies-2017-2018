let Rx = require('rxjs/Rx');

export function request(login) {
    return fetch(`https://api.github.com/users/${login}`)
        .then(function (response) {
            console.log(response.status);
            if(200<=response.status<400){
                return response.json();
            }else{
                return response.status;
            } 
        });
}