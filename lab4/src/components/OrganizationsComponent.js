import React from 'react';
import { connect } from "react-redux";


function BioComponent(props) {
    return (
        props.login!=='' &&  <div className="ORGS">
           
            <h3>Organizations</h3>
            <div>
                <img src={props.image} alt={props.image}/>
                <h4>{props.login}</h4>
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