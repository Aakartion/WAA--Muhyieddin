import React from "react";
import Post from "./Post";

const Posts = ({ posts, onSelectPost }) => {
  return (
    <div>
      <h2>Posts</h2>
      <div className="posts-container">
        {posts.map((post) => (
          <div
            key={post.id}
            className="post-container"
            onClick={() => onSelectPost(post.id)}
          >
            <Post post={post} />
          </div>
        ))}
      </div>
    </div>
  );
};

export default Posts;
