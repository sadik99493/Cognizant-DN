import React, { Component } from 'react';

class Post extends Component {
  render() {
    const { title, body } = this.props;
    return (
      <div className="post">
        <h3>{title}</h3>
        <p>{body}</p>
      </div>
    );
  }
}

export default Post;
