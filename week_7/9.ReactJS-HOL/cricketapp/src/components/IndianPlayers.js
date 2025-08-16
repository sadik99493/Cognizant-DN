
import React from 'react';

const IndianPlayers = () => {
  const oddTeam = ['Kohli', 'Rahane', 'Iyer', 'Gill', 'Bumrah'];
  const evenTeam = ['Rohit', 'Pant', 'Surya', 'Ashwin', 'Shami'];

  // Destructuring example
  const [p1, p2, ...restOdd] = oddTeam;
  const [e1, e2, ...restEven] = evenTeam;

  const T20players = ['Rohit', 'Hardik', 'Pant'];
  const RanjiTrophyPlayers = ['Rahane', 'Shaw'];

  // Merge arrays
  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        <li>{p1}</li>
        <li>{p2}</li>
        {restOdd.map((player, index) => <li key={index}>{player}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        <li>{e1}</li>
        <li>{e2}</li>
        {restEven.map((player, index) => <li key={index}>{player}</li>)}
      </ul>

      <h2>All Merged Players</h2>
      <ul>
        {allPlayers.map((player, index) => <li key={index}>{player}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
