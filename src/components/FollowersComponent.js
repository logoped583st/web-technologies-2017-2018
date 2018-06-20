import React from 'react';
import { connect } from "react-redux";


function FollowersComponent(props) {
    console.log(props);
    return (
        <div className="REPS">

            <h2>Repositories</h2>

        </div>
    );
}

const getState = (state) => {
    return {
        followers: state.reducerFollowers,
    };
};

export default connect(getState)(FollowersComponent);