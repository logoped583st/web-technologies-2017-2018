import React from 'react';
import { connect } from "react-redux";
import TabsComponent from './TabsComponent';


function MainUserInfoComponent(props) {
    return (
        <div className="MainUser">
                {props.error === true && <h2>USER NOT FOUND</h2>}

            <div className="image_table">
                <img src={props.image} alt={props.name} />
                <TabsComponent className="Table" />
            </div>
            <h2>{props.name}</h2>
            <h3>{props.login}</h3>
           
        </div>
    );
}

const getState = (state) => {
    return {
        error : state.reducerUser.error,
        name: state.reducerUser.name,
        image: state.reducerUser.image,
        login: state.reducerUser.login,
    };
};

export default connect(getState)(MainUserInfoComponent);