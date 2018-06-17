import React from 'react';
import { connect } from "react-redux";
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import TextAreaComponent from './TextAreaComponent';

class TabsComponent extends React.Component {
    constructor() {
        super();
        this.state = { tabIndex: 0 };
    }

    render() {
        return (

            <Tabs selectedIndex={this.state.tabIndex} onSelect={tabIndex => this.setState({ tabIndex })}>
                <TabList>
                    <Tab>Основное</Tab>
                    <Tab>Образование</Tab>
                    <Tab>Контакты</Tab>
                </TabList>
                <TabPanel>
                    <button >Edit1</button>
                    <TextAreaComponent id="textArea1" value = {this.state.reducerTextArea}/>
                </TabPanel>
                <TabPanel>
                    <button >Edit2</button>
                    <TextAreaComponent id="textArea2"/>
                </TabPanel>
                <TabPanel>
                    <button >Edit3</button>
                    <TextAreaComponent id="textArea3"/>
                </TabPanel>
            </Tabs>
        );
    }


}



export default connect(null)(TabsComponent);