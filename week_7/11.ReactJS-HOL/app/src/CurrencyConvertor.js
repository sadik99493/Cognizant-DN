import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor() {
    super();
    this.state = {
      rupees: '',
      euros: ''
    };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = () => {
    const euroRate = 0.011; // 1 INR = 0.011 EUR (example rate)
    const euros = this.state.rupees * euroRate;
    this.setState({ euros: euros.toFixed(2) });
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <input
          type="number"
          value={this.state.rupees}
          onChange={this.handleChange}
          placeholder="Enter amount in INR"
        />
        <button onClick={this.handleSubmit}>Convert</button>
        {this.state.euros && (
          <p>{this.state.rupees} INR = {this.state.euros} EUR</p>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
