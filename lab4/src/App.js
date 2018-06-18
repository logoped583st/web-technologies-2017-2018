import React from 'react';
import './App.css';
import store from './reducers/Store';
import { Provider } from "react-redux";
import { Fragment } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

import IndexComponent from './components/IndexComponent';
import MainUserInfoComponent from './components/MainUserInfoComponent';




class App extends React.Component {
    render() {
        return (
            <Router>
                <Provider store={store}>
                    <Fragment>
                        <Route path="/index" component={IndexComponent} />
                        <Route path="/repos" component={MainUserInfoComponent} />
                    </Fragment>

                </Provider>
            </Router>
        );
    }
}

export default App;
