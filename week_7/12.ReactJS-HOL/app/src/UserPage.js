import React from 'react';

const UserPage = () => {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can now book tickets for available flights.</p>
      <h3>Available Flights:</h3>
      <ul>
        <li>
          Flight 101 - Delhi to Mumbai
          <button>Book Now</button>
        </li>
        <li>
          Flight 202 - Bangalore to Chennai
          <button>Book Now</button>
        </li>
        <li>
          Flight 303 - Hyderabad to Pune
          <button>Book Now</button>
        </li>
      </ul>
    </div>
  );
};

export default UserPage;
