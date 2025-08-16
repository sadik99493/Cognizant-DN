import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [activeComponent, setActiveComponent] = useState('book');

  // Using element variable
  let content;
  if (activeComponent === 'book') {
    content = <BookDetails />;
  } else if (activeComponent === 'blog') {
    content = <BlogDetails />;
  } else {
    content = <CourseDetails />;
  }

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Blogger App</h1>

      <div style={{ marginBottom: '15px' }}>
        <button onClick={() => setActiveComponent('book')}>Show Books</button>
        <button onClick={() => setActiveComponent('blog')}>Show Blogs</button>
        <button onClick={() => setActiveComponent('course')}>Show Courses</button>
      </div>

      {content}


    </div>
  );
}

export default App;
