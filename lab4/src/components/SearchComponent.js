import React from 'react';
import { connect } from 'react-redux';
import { sendRequest } from '../requsets/requests'

class SearchComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text: ''
        };
        this.textChange = this.textChange.bind(this);
        this.search = this.search.bind(this);
    }

    textChange(e) {
        this.setState({ text: e.target.value })
    }

    search() {
        this.props.sendRequest(this.state.text);
    }

    render() {
        return (
            <div className='Search'>
                <input id='inputText' type='text' onChange={this.textChange} placeholder="Username" />
                <button onClick={this.search}>Search</button>
            </div>
        );
    }
}



export default connect(null ,{sendRequest})(SearchComponent);