import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor() {
    super();
    this.state = {
      count: 0,
      message: ''
    };
  }

  increment = () => {
    this.setState(prevState => ({ count: prevState.count + 1 }));
    this.sayHello();
  };

  decrement = () => {
    this.setState(prevState => ({ count: prevState.count - 1 }));
  };

  sayHello = () => {
    this.setState({ message: 'Hello! Welcome to React Events Example.' });
  };

  sayWelcome = (msg) => {
    this.setState({ message: msg });
  };

  handleSyntheticEvent = (e) => {
    e.preventDefault();  // Synthetic event
    this.setState({ message: 'I was clicked' });
  };

  render() {
    return (
      <div style={{ padding: "20px", fontFamily: "Arial" }}>
        <h1>React Event Handling</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <h2>Message: {this.state.message}</h2>
        <button onClick={() => this.sayWelcome('Welcome to React Events!')}>Say Welcome</button>
        <button onClick={this.handleSyntheticEvent}>OnPress</button>

        <hr />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
