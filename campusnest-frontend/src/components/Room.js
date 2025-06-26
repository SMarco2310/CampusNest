import React from 'react';

function Room(props) {

    return(
        <div className="container">
            <img src={props.image} alt={props.name}/>
            <h1>{props.name}</h1>
            <p>{props.description}</p>
            <p>Location: {props.location}</p>
            <p>Rating : {props.rating}</p>
        </div>

    );
}
export default Room;