
function Profile(props) {
    return (
        <div className="container">
            <h1>Profile Page</h1>
            <p>Welcome, {props.name}!</p>
            <p>Email: {props.email}</p>
            <p>Phone: {props.phone}</p>
            <button onClick={props.onEditProfile}>Edit Profile</button>
        </div>
    );
}