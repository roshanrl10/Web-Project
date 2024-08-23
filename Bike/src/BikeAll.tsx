import React, { useState, useEffect } from "react";
import axios from "axios";
import BikeCard from "./BikeCard"; // Adjust the path according to your file structure
import "./BikeAll.css";

interface Bike {
  id: number;
  bikeBrand: string;
  seat: number;
  price: string;
  bikeImage: string;
  isBooked: boolean;
  rentalEndDateTime: string;
}

const BikeAll: React.FC = () => {
  const [bikes, setBikes] = useState<Bike[]>([]);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchBikes = async () => {
      try {
        const response = await axios.get("http://localhost:8080/bikes/addlist");
        setBikes(response.data);
        setError(null); // Clear any previous error
      } catch (error) {
        console.error("Error fetching bikes:", error);
        setError("Failed to fetch bike data. Please try again later.");
      }
    };

    fetchBikes();
  }, []);

  const handleBook = (bikeId: number) => {
    console.log(`Bike ${bikeId} booked`);
  };

  return (
    <div className="bike-all-container">
      <h1>Bikes Available for Rent</h1>
      {error && <div className="error-message">{error}</div>}
      <div className="bike-list">
        {bikes.length > 0 ? (
          bikes.map((bike) => (
            <BikeCard key={bike.id} bike={bike} onBook={handleBook} />
          ))
        ) : (
          <p>No bikes available</p>
        )}
      </div>
    </div>
  );
};

export default BikeAll;
