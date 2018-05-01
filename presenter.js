let Rx = require('rxjs/Rx');
import { request } from './model.js'
import {setData} from './view.js'

export const sendRequest = function (login) {
    let observable = Rx.Observable.fromPromise(request(login));
    observable.subscribe(function (x) {
        setData(x);
    })
}
