import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore 
        Name="Sadik Shaik" 
        School="SGS High School" 
        Total={460} 
        Goal={5} 
      />
    </div>
  );
}

export default App;
