import React from 'react';
import './App.css';
import store from './reducers/store';
import {Provider} from "react-redux";
import { Fragment} from 'react';
import SearchComponent from './components/SearchComponent';
import MainUserInfoComponent from './components/MainUserInfoComponent';
import BioComponent from './components/BioComponent';
import AdditionalUserInfoComponent from './components/AdditionalUserInfoComponent';
import TabsComponent from './components/TabsComponent';
import OrganizationsComponent from './components/OrganizationsComponent';



class App extends React.Component {
  render(){
    return (
        <Provider store={store}>
            <Fragment>
                <SearchComponent/>
                <MainUserInfoComponent/>
                <BioComponent/>
                <AdditionalUserInfoComponent/>
                <OrganizationsComponent/>
                <TabsComponent/>
            </Fragment>
        </Provider>
    );
}
}

export default App;
