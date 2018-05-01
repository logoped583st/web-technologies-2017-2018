'use strict';

const data = document.getElementById('info');
const submit = document.getElementById('button');
const input = document.getElementById('input');

function create(elem) {
    return document.createElement(elem);
}

function checkImg(field, content, style) {
    field.setAttribute('class', style);
    return field.src = content
}

function checkText(field, content, style) {
    if (!content){
        return field.innerText = null;
    }
    field.setAttribute('class', style);
    return field.innerText = content;

}

function checkLink(field, content, style) {
    if (!content){
        return field.innerText = null;
    }
    field.setAttribute('class', style);
    field.setAttribute('href', content);
    return field.innerText = content;
}

function append(container, field) {
    return container.appendChild(field);
}

function clear(container) {
    while (container.firstChild){
        container.removeChild(container.firstChild);
    }
}

function setError(field, container, style ) {
    field.setAttribute('class', style);
    field.innerText = "ERROR";
    clear(container);
    append(container, field);
}
export {data, submit, create, input, checkImg, checkLink, checkText, append, clear, setError};