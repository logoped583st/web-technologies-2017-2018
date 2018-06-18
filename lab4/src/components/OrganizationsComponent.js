import React from 'react';
import { connect } from "react-redux";


function BioComponent(props) {
    console.log(props.login)
    return (
        props.login !== '' && <div className="ORGS">

            <h2>Organizations</h2>
            <div className="orgs_adds">
                <h3>{props.login}</h3>
                <img src={props.image} alt={props.image} />
            </div>
        </div>
    );
}

const getState = (state) => {
    return {
        login: state.reducerOrgs.login,
        image: state.reducerOrgs.image
    };
};

export default connect(getState)(BioComponent);