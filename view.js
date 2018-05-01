let Rx = require('rxjs/Rx');
import {b , create} from './presenter.js';
const a = document.querySelector("button");

console.log("Start");

Rx.Observable.fromEvent(a,'click')
            .subscribe(function () {
                 create();
            });