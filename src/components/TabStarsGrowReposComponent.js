import React from 'react';
import { connect } from "react-redux";
import { bindActionCreators } from 'redux';
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import TextAreaComponent from './TextAreaComponent';
import StarsGrowReposComponent from './StarsGrowReposComponent';
import { fetchStarsReposRequest } from '../actions/actions'
import { fetchGrowReposRequest } from '../actions/actions'

class TabsStarsGrowReposComponent extends React.Component {
    constructor() {
        super();
        this.state = { tabIndex: 0 };
    }

    render() {
        return (

            <Tabs selectedIndex={this.state.tabIndex} onSelect={tabIndex => this.setState({ tabIndex })}>
                <TabList>
                    <Tab>Grow Repositories</Tab>
                    <Tab>Top Repositories</Tab>
                </TabList>

                <TabPanel>

                    <StarsGrowReposComponent  request ={'GROW'}/>
                </TabPanel>

                <TabPanel>
                    <StarsGrowReposComponent request = {'TOP'}/>
                </TabPanel>

            </Tabs>
        );
    }


}


export default connect(null)(TabsStarsGrowReposComponent);