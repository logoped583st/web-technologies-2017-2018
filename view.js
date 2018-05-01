let Rx = require('rxjs/Rx');
import { sendRequest } from './presenter.js';
import { data, submit, input, create, checkImg, checkLink, checkText, append, clear, setError } from './dom.js'

const button = document.querySelector("button");
const inputText = document.querySelector("input");

if (new String(inputText.value).length === 0)
    button.disabled = true;

Rx.Observable.fromEvent(button, 'click')
    .subscribe(function (subscribe) {
        sendRequest(new String(inputText.value));
    });

Rx.Observable.fromEvent(inputText, "input")
    .map(function (text) {
        return new String(text.currentTarget.value.trim());
    })
    .subscribe(function (text) {
        if (text.length === 0) {
            button.disabled = true;
        } else {
            button.disabled = false;
        }
    })

export function setData(obj) {

    clear(data)

    let photo = create('img');
    let login = create('p');
    let name = create('p');
    let bio = create('p');
    let company = create('p');
    let location = create('p');
    let blog = create('a');

    checkImg(photo, obj.avatar_url, 'img-style');
    checkText(name, obj.name, 'name-style');
    checkText(login, obj.login, 'login-style');
    checkText(bio, obj.bio, 'bio-style');
    checkText(company, obj.company, 'company-style');
    checkText(location, obj.location, 'location-style');
    checkLink(blog, obj.blog, 'blog-style');

    let dataFragment = document.createDocumentFragment();
    append(dataFragment, photo);
    append(dataFragment, name);
    append(dataFragment, login);
    append(dataFragment, bio);
    append(dataFragment, company);
    append(dataFragment, location);
    append(dataFragment, blog);
    append(data, dataFragment);
}

export function errorReuqest(){
    let error = create('p');
    return setError(error, data, 'error-style');
}

