const baseUrl = 'https://api.github.com/users/';
const allReposUrl = 'https://api.github.com/search/repositories?q='

export const sendRequest = (login) => {
    return fetch(baseUrl + login)
        .then(res => res.json())
}

export const sendRequestOrgs = (login)  => {
    return fetch(baseUrl + login + "/orgs")
        .then(res => res.json())

}

export const sendRequestFollowers = (login)  => {
    return fetch(baseUrl + login + "/followers")
        .then(res => res.json())
}

export const sendRequestRepos = (login)  => {
    return fetch(baseUrl + login + "/repos")
        .then(res => res.json())   
}

export const sendRequestAllRepos = (login)  => {
    return fetch(allReposUrl + login)
        .then(res => res.json())   
}
