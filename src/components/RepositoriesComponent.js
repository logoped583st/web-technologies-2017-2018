import React from 'react';
import { connect } from "react-redux";


function RepositoriesComponent(props) {

    return (

        <div className="REPS">

            <h2>Repositories</h2>

        </div>
    );
}

const getState = (state) => {
    return {
        repos: state.reducerFollowers
    };
};

export default connect(getState)(RepositoriesComponent);