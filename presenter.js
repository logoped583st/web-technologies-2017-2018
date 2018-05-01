let Rx = require('rxjs/Rx');
import { request } from './model.js'
import { setData, errorReuqest } from './view.js'

export const sendRequest = function (login) {
    let observable = Rx.Observable.fromPromise(request(login));
    observable.subscribe(function (x) {
        console.log(x);
        if (typeof (x) !== 'number') {
            setData(x);
        }else errorReuqest();
    })
}
