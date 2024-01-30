import React from "react";
import Post from "./Post";

const Posts = ({ posts }) => {
  return (
    <div>
      <h2>Posts</h2>
      {posts.map((post) => (
        <Post key={post.id} post={post} />
      ))}
    </div>
  );
};

export default Posts;