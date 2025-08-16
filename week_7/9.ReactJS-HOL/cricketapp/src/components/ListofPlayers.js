
import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat', score: 85 },
    { name: 'Rohit', score: 45 },
    { name: 'Dhoni', score: 95 },
    { name: 'Rahul', score: 65 },
    { name: 'Pant', score: 70 },
    { name: 'Jadeja', score: 60 },
    { name: 'Ashwin', score: 30 },
    { name: 'Bumrah', score: 50 },
    { name: 'Shami', score: 55 },
    { name: 'Surya', score: 90 },
    { name: 'Gill', score: 100 }
  ];

  const filteredPlayers = players.filter(player => player.score >= 70);

  return (
    <div>
      <h2>Players with Score ≥ 70</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
