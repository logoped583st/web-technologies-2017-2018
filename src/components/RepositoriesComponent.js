import React from 'react';
import { connect } from "react-redux";


function RepositoriesComponent(props) {

    var repositoreidsArr=[];

    for (const repos in props.repos) {
        if (props.repos.hasOwnProperty(repos)) {
            repositoreidsArr.push(props.repos[repos])
        }
    }

    return (
        (repositoreidsArr.length!==0)&& <div className="REPS">
            
            <h2>Repositories</h2>
            
            {repositoreidsArr.map(function(item) { 
                 return (<div className="orgs_adds">
                    <h2>{item.name}</h2>  
                    <h3> {item.html_url}   <a>{item.language}</a></h3>
                </div>)
            })}
            

        </div>
    );
}

const getState = (state) => {
    console.log(state);
    return {
        repos: state.reduserRepos
    };
};

export default connect(getState)(RepositoriesComponent);