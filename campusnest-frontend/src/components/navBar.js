import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min'; // Important for toggle functionality

function NavBar() {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm py-2">
            <div className="container-fluid">

                {/* Left: Logo */}
                <a className="navbar-brand" href="/">
                    <img
                        src="/campusnest_logo.png"
                        alt="CampusNest Logo"
                        style={{ height: '40px' }}
                    />
                </a>

                {/* Hamburger Toggler */}
                <button
                    className="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarContent"
                    aria-controls="navbarContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                >
                    <span className="navbar-toggler-icon"></span>
                </button>

                {/* Collapsible Content */}
                <div className="collapse navbar-collapse justify-content-between" id="navbarContent">

                    {/* Center: Nav Links */}
                    <ul className="navbar-nav mx-auto mb-2 mb-lg-0 gap-lg-4">
                        <li className="nav-item">
                            <a className="nav-link" href="/">Home</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#about">About Us</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#contact">Contact Us</a>
                        </li>
                    </ul>

                    {/* Right: Auth Buttons */}
                    <div className="d-flex gap-2 mt-3 mt-lg-0">
                        <a href="/login" className="btn btn-outline-primary">Login</a>
                        <a href="/register" className="btn btn-primary">Sign Up</a>
                    </div>

                </div>
            </div>
        </nav>
    );
}

export default NavBar;
