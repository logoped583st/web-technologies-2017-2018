import React from 'react';
import { connect } from "react-redux";
import { fetchReposRequest } from '../actions/actions'
import { bindActionCreators } from 'redux';


function RepositoriesComponent(props) {
    if (props.repos.login==='' && props.login !== undefined)
        props.fetchReposRequest(props.login)

    var repositoreidsArr = [];
    var languageMap = new Map();

    for (const repos in props.repos) {
        if (props.repos.hasOwnProperty(repos)) {
            repositoreidsArr.push(props.repos[repos])
            // languageMap.set(props.repos[repos].language,props.repos[repos].language)
        }
    }

    var languageArr = [];
    
   
    console.log(languageArr);
    return (
        (props.repos.login!=='') && <div className="REPS">

            

            <select className="Type">
                <option value="public">All</option>
                <option value="public">public</option>
                <option value="private">private</option>
                <option value="forked">forked</option>
            </select>

            

            <h2>Repositories</h2>

            {repositoreidsArr.map(function (item) {
                return (<div className="orgs_adds">
                    <h2>{item.name}</h2>
                    <h3> {item.html_url}   {item.language}</h3>
                </div>)
            })}


        </div>
    );
}

const getState = (state) => {
    console.log(state);
    return {
        repos: state.reduserRepos,
        login: state.reducerUser.login
    };
};

const mapDispatchToProps = dispatch => bindActionCreators({
    fetchReposRequest,
}, dispatch);

export default connect(getState, mapDispatchToProps)(RepositoriesComponent);