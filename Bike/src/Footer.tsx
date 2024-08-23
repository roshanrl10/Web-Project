import React from "react";
import "./Footer.css";
import { Link } from "react-router-dom";
import facebookLogo from "./assets/facebooklogo.png";
import instagramLogo from "./assets/instagramlogo.png";
import whatsappLogo from "./assets/whatsapplogo.png";
import phoneIcon from "./assets/phone.png";
import emailIcon from "./assets/emailicon.png";

const Footer: React.FC = () => {
  return (
    <footer className="footer-main">
      <div className="footer-container-main">
        <div className="footer-section-main social-main">
          <h3>Follow Us</h3>
          <div className="social-icons-main">
            <a
              href="https://www.facebook.com/"
              target="_blank"
              rel="noopener noreferrer"
            >
              <img src={facebookLogo} alt="Facebook" />
            </a>
            <a
              href="https://www.instagram.com/"
              target="_blank"
              rel="noopener noreferrer"
            >
              <img src={instagramLogo} alt="Instagram" />
            </a>
            <a
              href="https://web.whatsapp.com/"
              target="_blank"
              rel="noopener noreferrer"
            >
              <img src={whatsappLogo} alt="WhatsApp" />
            </a>
          </div>
        </div>
        <div className="footer-section-main contact-main">
          <h3>Contact Us</h3>
          <p>
            <img src={phoneIcon} alt="Phone" /> Emergency Contact: 9842372593
          </p>
          <p>
            <img src={emailIcon} alt="Email" /> bikesharing@example.com
          </p>
        </div>
        <div className="footer-section-main company-main">
          <h3>Company</h3>
          <Link to="about">
            <p>About Us</p>
          </Link>
          <Link to="terms">
            <p>Terms & Conditions</p>
          </Link>
          <Link to="privacy">
            <p>Privacy Policy</p>
          </Link>
          <Link to="/">
            <p>Home Page</p>
          </Link>
          <Link to="late-return-policy">
            <p>Late Return Policy</p>
          </Link>
          <Link to="cancellation-policy">
            <p>Cancellation Policy</p>
          </Link>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
