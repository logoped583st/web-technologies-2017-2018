import React from 'react';
import { connect } from "react-redux";


function MainUserInfoComponent(props) {
    return (
        <div className="MainUser">
            <img src={props.image} alt={props.name} />
            <h2>{props.name}</h2>
            <h3>{props.login}</h3>

        </div>
    );
}

const getState = (state) => {
    console.log(state)
    return {
        name: state.reducerUser.name,
        image: state.reducerUser.image,
        login: state.reducerUser.login,
    };
};

export default connect(getState)(MainUserInfoComponent);