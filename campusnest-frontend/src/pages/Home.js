import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import NavBar from "../components/navBar";

function Home() {
    return (
        <div>
            <NavBar />


            {/* Section 1: Hero / Welcome */}
            <section className="bg-light py-5 text-center">
                <div className="container">
                    <h1 className="display-4 fw-bold">Welcome to CampusNest</h1>
                    <p className="lead mt-3">
                        Your one-stop solution for hostel and room management.
                    </p>
                    <p>
                        Explore our features and find the perfect accommodation for your needs.
                    </p>
                    <a href="/hostels" className="btn btn-primary btn-lg mt-3">Book a Room</a>
                </div>
            </section>

            {/* Section 2: About Us */}
            <section id="about" className="py-5 bg-white">
                <div className="container">
                    <h2 className="text-center mb-4">About Us</h2>
                    <p className="text-center mx-auto" style={{ maxWidth: "800px" }}>
                        CampusNest is a platform built to simplify the process of finding, managing,
                        and booking student accommodation. We connect students with trusted hostel managers,
                        providing transparency, comfort, and convenience.
                    </p>
                </div>
            </section>

            {/* Section 3: Features */}
            <section className="bg-light py-5">
                <div className="container">
                    <h2 className="text-center mb-4">Our Services</h2>
                    <div className="row text-center">
                        <div className="col-md-4 mb-4">
                            <div className="card h-100 p-4">
                                <h5>Browse Hostels</h5>
                                <p>View verified hostels with photos, prices, and facilities.</p>
                            </div>
                        </div>
                        <div className="col-md-4 mb-4">
                            <div className="card h-100 p-4">
                                <h5>Room Booking</h5>
                                <p>Easily reserve rooms online and get confirmation from hostel managers.</p>
                            </div>
                        </div>
                        <div className="col-md-4 mb-4">
                            <div className="card h-100 p-4">
                                <h5>Secure Communication</h5>
                                <p>Get in touch with hostel managers and stay updated on your booking status.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            {/* Section 4: Contact Us */}
            <section id="contact" className="py-5 bg-white">
                <div className="container">
                    <h2 className="text-center mb-4">Contact Us</h2>
                    <div className="row justify-content-center">
                        <div className="col-md-6 text-center">
                            <p>Email: <a href="mailto:support@campusnest.com">support@campusnest.com</a></p>
                            <p>Phone: +233 50 123 4567</p>
                            <p>Location: Accra, Ghana</p>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    );
}

export default Home;
