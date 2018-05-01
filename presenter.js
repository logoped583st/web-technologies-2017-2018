let Rx = require('rxjs/Rx');
import {setObj} from './model.js'
export var create = function(){
    'use strict';
    fetch('https://api.github.com/users/fasd')
        .then(function (response) {
            var observable = Rx.Observable.fromPromise(response.json());
            observable.subscribe(function subscribe(x){
                setObj(x);
            })
        });
    }
