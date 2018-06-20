import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { fetchUserRequest } from '../actions/actions'
import { fetchOrgsRequest } from '../actions/actions'
import { fetchFollowersRequest} from '../actions/actions'
import { fetchReposRequest} from '../actions/actions'


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
            this.search();
        }
    }

    textChange(e) {
        this.setState({ text: e.target.value })
    }

    search() {
        this.props.fetchUserRequest(this.state.text);
        this.props.fetchOrgsRequest(this.state.text);
        this.props.fetchFollowersRequest(this.state.text);
    }

    render() {
        return (
            <div className='Search'>
                <input id='inputText' type='text' onChange={this.textChange} placeholder="Username" onKeyDown={this.enterPress} />
                <button onClick={this.search}>Search</button>
            </div>
        );
    }
}
const mapDispatchToProps = dispatch => bindActionCreators({
    fetchUserRequest,
    fetchOrgsRequest,
    fetchFollowersRequest,
    fetchReposRequest,
}, dispatch);


export default connect(null, mapDispatchToProps)(SearchComponent);