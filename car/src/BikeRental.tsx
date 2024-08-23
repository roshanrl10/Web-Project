import React from "react";
import "./BikeRental.css";
import { Link } from "react-router-dom";
import bikeImage from "./assets/bike.jpg"; // Change image to a bike image
import locationIcon from "./assets/location.png";
import userIcon from "./assets/user.jpg";

const BikeRental: React.FC = () => {
  return (
    <div className="bike-body">
      <header className="bike-header">
        <h1>Rent Bike</h1>
        <div className="bike-filters">
          <div className="bike-dropdown">
            <label htmlFor="bike-type">Bike Type</label>
            <select id="bike-type">
              <option value="all">All</option>
              <option value="mountain">Mountain</option>
              <option value="road">Road</option>
              <option value="hybrid">Hybrid</option>
            </select>
          </div>
          <div className="bike-dropdown">
            <label htmlFor="bike-brand">Brand</label>
            <select id="bike-brand">
              <option value="all">All</option>
              <option value="Giant">Giant</option>
              <option value="Trek">Trek</option>
              <option value="Specialized">Specialized</option>
              <option value="Cannondale">Cannondale</option>
            </select>
          </div>
          <div className="bike-dropdown">
            <label htmlFor="price-filter">Price</label>
            <select id="price-filter">
              <option value="10-30">$10-$30</option>
              <option value="31-60">$31-$60</option>
              <option value="61-100">$61-$100</option>
              <option value="101-150">$101-$150</option>
            </select>
          </div>
        </div>
      </header>
      <div className="bike-vehicle-grid">
        {Array.from({ length: 14 }, (_, index) => (
          <div className="bike-vehicle-card" key={index}>
            <p>{getBikeName(index)}</p>
            <div className="bike-image-container">
              <img src={bikeImage} alt={`Bike ${index + 1}`} />
            </div>
            <div className="bike-info-container">
              <div className="bike-location">
                <img src={locationIcon} alt="Location Icon" />
                <span>Kathmandu</span>
              </div>
              <div className="bike-seats">
                <img src={userIcon} alt="User Icon" />
                <span>1 Seat</span>
              </div>
              <div className="bike-price-section">
                <div className="bike-price">
                  <span className="bike-estimate">Estimated Price</span>
                  <span className="bike-amount">{getBikePrice(index)}/day</span>
                </div>
                <div className="bike-book-button">
                  <Link to="/bikebooking">
                    <button>Book</button>
                  </Link>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

const getBikeName = (index: number) => {
  const names = [
    "Mountain Bike",
    "Mountain Bike",
    "Road Bike",
    "Road Bike",
    "Hybrid Bike",
    "Hybrid Bike",
    "Specialized",
    "Specialized",
    "Cannondale",
    "Cannondale",
    "Trek",
    "Trek",
    "Giant",
    "Giant",
  ];
  return names[index];
};

const getBikePrice = (index: number) => {
  const prices = [
    "$25",
    "$25",
    "$45",
    "$45",
    "$35",
    "$35",
    "$60",
    "$60",
    "$50",
    "$50",
    "$40",
    "$40",
    "$55",
    "$55",
  ];
  return prices[index];
};

export default BikeRental;
