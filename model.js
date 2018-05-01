let Rx = require('rxjs/Rx');

export function request(login) {
    return fetch(`https://api.github.com/users/${login}`)
        .then(function (response) {
            return response.json();
        });
}