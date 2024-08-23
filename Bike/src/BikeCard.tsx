import React from "react";
import "./BikeCard.css"; // Ensure you create and style this CSS file accordingly

interface BikeCardProps {
  bike: {
    id: number;
    bikeBrand: string;
    seat: number;
    price: string;
    bikeImage: string;
    isBooked: boolean;
    rentalEndDateTime: string;
  };
  onBook: (bikeId: number) => void; // Ensure this is typed correctly
}

const BikeCard: React.FC<BikeCardProps> = ({ bike, onBook }) => {
  return (
    <div className="bike-card">
      <img
        src={bike.bikeImage}
        alt={`${bike.bikeBrand} image`}
        className="bike-image"
      />
      <h2>{bike.bikeBrand}</h2>
      <p>Seats: {bike.seat}</p>
      <p>Price: {bike.price}</p>
      <p>Status: {bike.isBooked ? "Booked" : "Available"}</p>
      <p>Rental End: {bike.rentalEndDateTime}</p>
      <button onClick={() => onBook(bike.id)} disabled={bike.isBooked}>
        {bike.isBooked ? "Booked" : "Book Now"}
      </button>
    </div>
  );
};

export default BikeCard;
