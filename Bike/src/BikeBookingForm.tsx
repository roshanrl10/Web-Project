import React, { useState } from "react";
import "./BikeBookingForm.css"; // Ensure this CSS file is created and styled accordingly
import bikebooking from "./assets/bikeform.png"; // Update the image path to reflect bikes
import { Link } from "react-router-dom";

const BikeBookingForm: React.FC = () => {
  const [showPopup, setShowPopup] = useState(false);

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    // Add your form submission logic here
    setShowPopup(true);
  };

  const handleClosePopup = () => {
    setShowPopup(false);
  };

  return (
    <div
      className="bikebooking-body"
      style={{
        background: `url(${bikebooking}) no-repeat center center/cover`,
      }}
    >
      <div className="bikebooking-main">
        <h2>Book Your Bike Today!</h2>
        <form id="bikeBookingForm" onSubmit={handleSubmit}>
          <label htmlFor="pickup">Pickup</label>
          <input type="datetime-local" id="pickup" name="pickup" />

          <label htmlFor="dropoff">Drop off</label>
          <input type="datetime-local" id="dropoff" name="dropoff" required />

          <label htmlFor="name">Your name</label>
          <input type="text" id="name" name="name" required />

          <label htmlFor="phone">Phone number</label>
          <input type="tel" id="phone" name="phone" required />

          <label htmlFor="email">Email address</label>
          <input type="email" id="email" name="email" required />

          <div className="bikebooking-policy">
            <Link to="/contract" target="_blank">
              <h4>Before Booking Read Our Terms And Conditions</h4>
            </Link>
          </div>

          <div className="bikebooking-checkbox-container">
            <input type="checkbox" id="terms" name="terms" />
            <label htmlFor="terms">I have read all terms & conditions</label>
          </div>

          <button type="submit" id="bikebooking-confirmBookingButton">
            CONFIRM BIKE BOOKING
          </button>
        </form>
      </div>

      {showPopup && (
        <div id="bikebooking-popup" className="bikebooking-popup">
          <div className="bikebooking-popup-content">
            <span className="bikebooking-close-btn" onClick={handleClosePopup}>
              &times;
            </span>
            <p>Booking Successful!</p>
          </div>
        </div>
      )}
    </div>
  );
};

export default BikeBookingForm;
