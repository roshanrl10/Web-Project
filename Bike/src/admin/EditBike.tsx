import React, { useState, useEffect } from "react";
import axios from "axios";
import "./EditBike.css";

interface EditBikeModalProps {
  isOpen: boolean;
  onClose: () => void;
  bike: {
    id: number;
    bikeBrand: string;
    seat: number;
    price: string;
    bikeImage: string;
  } | null;
  onSave: (updatedBike: {
    id: number;
    bikeBrand: string;
    seat: number;
    price: string;
    bikeImage: string;
  }) => void;
}

const EditBikeModal: React.FC<EditBikeModalProps> = ({
  isOpen,
  onClose,
  bike,
  onSave,
}) => {
  const [bikeBrand, setBikeBrand] = useState("");
  const [seat, setSeats] = useState<number | "">("");
  const [price, setPrice] = useState("");
  const [imageFile, setImageFile] = useState<File | null>(null);
  const [imagePreview, setImagePreview] = useState<string | null>(null);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  useEffect(() => {
    if (bike) {
      setBikeBrand(bike.bikeBrand);
      setSeats(bike.seat);
      setPrice(bike.price);
      setImagePreview(bike.bikeImage); // Initial image preview set from existing bike image
    }
  }, [bike]);

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files.length > 0) {
      const file = e.target.files[0];
      setImageFile(file);
      setImagePreview(URL.createObjectURL(file)); // Set image preview for the selected file
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (bike) {
      try {
        const formData = new FormData();
        formData.append("bikeBrand", bikeBrand);
        formData.append("seat", seat.toString());
        formData.append("price", price);

        if (imageFile) {
          formData.append("bikeImage", imageFile);
        }

        const response = await axios.put(
          `http://localhost:8080/bikes/bike/${bike.id}`,
          formData,
          {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          }
        );

        console.log("Response:", response);

        const updatedBike = {
          ...bike,
          bikeBrand,
          seat,
          price,
          bikeImage: imageFile
            ? URL.createObjectURL(imageFile)
            : bike.bikeImage,
        };

        onSave(updatedBike);
        onClose();
      } catch (error) {
        setErrorMessage(
          error.response?.data || "An error occurred while updating the bike."
        );
        console.error("Error updating bike:", errorMessage);
      }
    }
  };

  if (!isOpen || !bike) return null;

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <button className="modal-close" onClick={onClose}>
          ×
        </button>
        <h2>Edit Bike</h2>
        {errorMessage && <p className="error-message">{errorMessage}</p>}
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="bikeBrand">Bike Brand:</label>
            <input
              type="text"
              id="bikeBrand"
              value={bikeBrand}
              onChange={(e) => setBikeBrand(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="seats">Seats:</label>
            <input
              type="number"
              id="seats"
              value={seat}
              onChange={(e) => setSeats(Number(e.target.value))}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="price">Price:</label>
            <input
              type="text"
              id="price"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="image">Bike Image:</label>
            <input type="file" id="image" onChange={handleFileChange} />
            {imagePreview && (
              <img src={imagePreview} alt="Preview" className="image-preview" />
            )}
          </div>
          <button type="submit" className="submit-button">
            Save Changes
          </button>
        </form>
      </div>
    </div>
  );
};

export default EditBikeModal;
