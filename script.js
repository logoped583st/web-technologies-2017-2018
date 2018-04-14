let Rx = require('rxjs/Rx');

const a = document.querySelector("button");

console.log("Start");

Rx.Observable.from(a,'click')
            .observe()
            .subscribe(function () {

               // return console.log("click");
            });