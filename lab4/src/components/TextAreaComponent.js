import React from 'react';
import { connect } from 'react-redux';

class TextAreaComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text: ""
        };
        this.textChange = this.textChange.bind(this);
    }


    textChange(e) {
        this.setState({ text: e.target.value })
    }

  

    render() {
        return (
            <textarea id='inputText' type='text' onChange={this.textChange} value={this.state.text} onKeyDown={this.enterPress} />
        );
    }
}



export default connect(null)(TextAreaComponent);