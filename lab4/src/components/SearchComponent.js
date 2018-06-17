import React from 'react';
import { connect } from 'react-redux';
import { sendRequest } from '../requsets/requests'
import { sendRequestOrgs } from '../requsets/requests'

class SearchComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text: ''
        };
        this.textChange = this.textChange.bind(this);
        this.search = this.search.bind(this);
        this.enterPress = this.enterPress.bind(this);
    }

    enterPress = (e) => {
        if (e.key === 'Enter') {
            console.log("ENTER");
            this.search();
        }
    }

    textChange(e) {
        this.setState({ text: e.target.value })
    }

    search() {
        this.props.sendRequest(this.state.text);
        this.props.sendRequestOrgs(this.state.text);
    }

    render() {
        return (
            <div className='Search'>
                <input id='inputText' type='text' onChange={this.textChange} placeholder="Username"  onKeyDown={this.enterPress}/>
                <button onClick={this.search}>Search</button>
            </div>
        );
    }
}



export default connect(null, { sendRequest, sendRequestOrgs })(SearchComponent);