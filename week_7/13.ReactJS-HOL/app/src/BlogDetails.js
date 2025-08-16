import React from 'react';

const BlogDetails = () => {
  const blogs = [
    { id: 1, title: "React Hooks Deep Dive", date: "2025-08-01" },
    { id: 2, title: "Conditional Rendering in React", date: "2025-07-20" }
  ];

  return (
    <div>
      <h2> Blog Details</h2>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>
            {blog.title} — <i>{blog.date}</i>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BlogDetails;
