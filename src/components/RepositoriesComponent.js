import React from 'react';
import { connect } from "react-redux";
import { fetchReposRequest } from '../actions/actions'
import { bindActionCreators } from 'redux';


class RepositoriesComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            type: "All_repos",
            language: "All_Language",
        };
        if (this.props.login !== '' && this.props.login !== undefined) {
            this.props.fetchReposRequest(this.props.login)
        }

        this.languageChange = this.languageChange.bind(this);
        this.typeChange = this.typeChange.bind(this);
    }

    languageChange(event) {
        this.setState({ language: event.target.value })
    }

    typeChange(event) {
        this.setState({ type: event.target.value })
    }

    render() {
        var repositoreidsArr = [];
        var languageMap = new Map();
        for (const repos in this.props.repos) {
            if (this.props.repos.hasOwnProperty(repos)) {
                repositoreidsArr.push(this.props.repos[repos])
                languageMap.set(this.props.repos[repos].language, this.props.repos[repos].language)
            }
        }

        var languageArr = [];

        languageMap.forEach(item => {
            languageArr.push(item);
        })

        var localState = this.state;
        return (
            (this.props.login !== '' && this.props.login !== undefined) && <div className="REPS">

                <select className="Type" onChange={this.typeChange} value={this.state.type}>
                    <option className='All_repos' value="All_repos">All</option>
                    <option value="public">public</option>
                    <option value="private">private</option>
                </select>

                <select className="Language" onChange={this.languageChange} value={this.state.language}>
                    <option value="All_Language">All</option>
                    {languageArr.map(item => {
                        if (item !== null) {
                            return <option value={item}>{item}</option>
                        }
                    })}
                </select>

                <h2>Repositories</h2>

                {repositoreidsArr.map(function (item) {
                    switch (localState.type) {
                        case "public": {
                            if (item.private === false && (localState.language === "All_Language" || item.language === localState.language)) {
                                return (<div className="orgs_adds ">
                                    <h2>{item.name}</h2>
                                    <h3> {item.html_url}   {item.language}</h3>
                                </div>)
                            }
                            break;
                        }
                        case "private": {
                            if (item.private === true && (localState.language === "All_Language" || item.language === localState.language)) {
                                return (<div className="orgs_adds ">
                                    <h2>{item.name}</h2>
                                    <h3> {item.html_url}   {item.language}</h3>
                                </div>)
                            }
                            break;
                        }
                        case "All_repos": {
                            if (localState.language === "All_Language" || item.language === localState.language){
                                return (<div className="orgs_adds">
                                    <h2>{item.name}</h2>
                                    <h3> {item.html_url}   {item.language}</h3>
                                </div>)
                            }
                            break;
                        }
                    }
                })}
            </div>
        );
    }
}
const getState = (state) => {
    return {
        repos: state.reduserRepos,
        login: state.reducerUser.login
    };
};

const mapDispatchToProps = dispatch => bindActionCreators({
    fetchReposRequest,
}, dispatch);

export default connect(getState, mapDispatchToProps)(RepositoriesComponent);