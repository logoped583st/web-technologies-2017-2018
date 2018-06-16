import React from 'react';
import './App.css';
import store from './reducers/store';
import {Provider} from "react-redux";
import { Fragment} from 'react';
import SearchComponent from './components/SearchComponent';



class App extends React.Component {
  render(){
    return (
        <Provider store={store}>
            <Fragment>
              
                <SearchComponent/>
            </Fragment>
        </Provider>
    );
}
}

export default App;
