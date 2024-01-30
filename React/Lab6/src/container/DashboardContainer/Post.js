import React from "react";

const Post = ({ post }) => {
  return (
    <div className="postContainer">
      <h3>Id: {post.id}</h3>
      <h3>Title: {post.title}</h3>
      <h3>Author: {post.author}</h3>
    </div>
  );
};

export default Post;
