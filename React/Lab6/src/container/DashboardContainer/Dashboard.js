import React, { useState } from "react";
import Posts from "./Posts";
import "./Dashboard.css";

const Dashboard = () => {
  const [posts, setPosts] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" },
  ]);

  const updateFirstPostTitle = (newTitle) => {
    const updatedPosts = [...posts];
    updatedPosts[0].title = newTitle;
    setPosts(updatedPosts);
  };

  return (
    <div className="dashboard-container">
      <h1>Lab6 Application</h1>
      <Posts posts={posts} />
      <input
        type="text"
        placeholder="New Title"
        onChange={(e) => updateFirstPostTitle(e.target.value)}
      />
    </div>
  );
};

export default Dashboard;
