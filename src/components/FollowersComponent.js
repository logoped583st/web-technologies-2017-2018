import React from 'react';
import { connect } from "react-redux";


function FollowersComponent(props) {

    var followersArr = [];

    for (const follower in props.followers) {
        if (props.followers.hasOwnProperty(follower)) {
            followersArr.push(props.followers[follower])
        }
    }

    return (
        (followersArr.length !== 0) && <div className="REPS">


            <h2>Organizations</h2>

            {followersArr.map(function (item) {
                return (<div className="orgs_adds">
                    <h3>{item.login}</h3>
                    <img src={item.avatar_url} alt={item.avatar_url} />
                </div>)
            })}


        </div>
    );
}

const getState = (state) => {
    console.log(state);
    return {
        followers: state.reduserFollowers,
    };
};

export default connect(getState)(FollowersComponent);