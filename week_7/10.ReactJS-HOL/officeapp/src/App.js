import React from 'react';
import logo from './logo.svg';
import pic from './pic.jpeg';
import pic2 from './pic2.jpeg';
function App() {
  const office = {
    name: "Skyline Tower",
    rent: 55000,
    address: "5th Avenue, New York"
  };

  const officeList = [
    {
      id: 1,
      name: "Skyline Tower",
      rent: 55000,
      address: "5th Avenue, New York",
      image:pic2
    },
    {
      id: 2,
      name: "Palm Plaza",
      rent: 65000,
      address: "Main Street, Los Angeles",
      image: pic2
    },
    {
      id: 3,
      name: "Tech Park",
      rent: 40000,
      address: "MG Road, Bangalore",
      image: pic2
    }
  ];

  const getRentColor = (rent) => {
    return {
      color: rent >= 60000 ? 'green' : 'red',
      fontWeight: 'bold'
    };
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1> Office Space Rental App</h1>
      <img src={pic} alt="Office Banner" />

      <h2>Featured Office</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p><strong>Rent:</strong> <span style={getRentColor(office.rent)}>{office.rent}</span></p>
      <p><strong>Address:</strong> {office.address}</p>

      <h2>Available Offices</h2>
      {officeList.map((item) => (
        <div key={item.id} style={{ border: "1px solid #ccc", marginBottom: "15px", padding: "10px" }}>
          <img src={item.image} alt={item.name} style={{ width: "300px", height: "150px" }} />
          <h3>{item.name}</h3>
          <p><strong>Rent:</strong> <span style={getRentColor(item.rent)}>{item.rent}</span></p>
          <p><strong>Address:</strong> {item.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
