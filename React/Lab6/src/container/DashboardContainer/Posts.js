import React from "react";
import Post from "./Post";

const Posts = ({ posts }) => {
  return (
    <div className="posts-container">
      <h2>Posts</h2>
      {posts.map((post) => (
        <div key={post.id} className="post-container">
          <Post post={post} />
        </div>
      ))}
    </div>
  );
};

export default Posts;
