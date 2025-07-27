import React from 'react';
import CohortDetails from './components/CohortDetails';
import './App.css';

const App = () => {
  const cohorts = [
    { name: 'React Bootcamp', startDate: '2025-07-01', status: 'ongoing' },
    { name: 'Node Mastery', startDate: '2025-06-15', status: 'completed' },
    { name: 'DevOps Essentials', startDate: '2025-05-20', status: 'completed' }
  ];

  return (
    <div className="App">
      <h1>My Academy Dashboard</h1>
      <div className="dashboard">
        {cohorts.map((cohort, index) => (
          <CohortDetails key={index} cohort={cohort} />
        ))}
      </div>
    </div>
  );
};

export default App;
