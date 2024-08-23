import React from "react";
import "./CancellationPolicy.css";

const CancellationPolicy: React.FC = () => {
  return (
    <div className="cancellation-policy">
      <h2 className="policy-title">Bike Rental Cancellation Policy</h2>
      <p className="policy-intro">
        We understand that plans can change. Please review our cancellation
        policy for bike rentals below:
      </p>
      <div className="policy-details">
        <h3 className="section-title">Cancellation Periods</h3>
        <ul className="policy-list">
          <li className="policy-item">
            <strong>More than 24 hours before the rental:</strong> Full refund.
          </li>
          <li className="policy-item">
            <strong>Within 24 hours of the rental:</strong> 50% refund.
          </li>
          <li className="policy-item">
            <strong>No-show or less than 2 hours:</strong> No refund.
          </li>
        </ul>
      </div>
      <div className="policy-footer">
        <p>
          If you have any questions about our bike rental cancellation policy,
          please contact us at [Your Contact Number].
        </p>
      </div>
    </div>
  );
};

export default CancellationPolicy;
