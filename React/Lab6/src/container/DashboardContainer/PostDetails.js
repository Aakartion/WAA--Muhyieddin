import React from "react";

const PostDetails = ({ post }) => {
  return (
    <div>
      <h3>{post.title}</h3>
      <h3>{post.author}</h3>
      <button>Edit</button>
      <button>Delete</button>
    </div>
  );
};

export default PostDetails;
