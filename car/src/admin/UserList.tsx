import React, { useState, useEffect } from "react";
import axios from "axios";
import "./UserList.css";

interface User {
  id: number;
  username: string;
  full_name: string;
  email: string;
  contact_number: string; // Updated field for bike application
}

const UserList: React.FC = () => {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    // Fetch users from backend
    const fetchUsers = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/bike-registration/list"
        ); // Updated endpoint for bike application
        setUsers(response.data);
      } catch (error) {
        console.error("Error fetching users:", error);
      }
    };

    fetchUsers();
  }, []);

  const handleDelete = async (userId: number) => {
    try {
      await axios.delete(
        `http://localhost:8080/bike-registration/list/${userId}`
      ); // Updated endpoint for bike application
      setUsers(users.filter((user) => user.id !== userId));
      console.log(`User with ID: ${userId} deleted successfully`);
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  };

  return (
    <div className="user-list-container">
      <table className="user-list-table">
        <thead>
          <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact</th> {/* Updated to match bike application */}
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.username}</td>
              <td>{user.full_name}</td>
              <td>{user.email}</td>
              <td>{user.contact_number}</td>{" "}
              {/* Updated to match bike application */}
              <td>
                <button
                  className="delete-button"
                  onClick={() => handleDelete(user.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserList;
