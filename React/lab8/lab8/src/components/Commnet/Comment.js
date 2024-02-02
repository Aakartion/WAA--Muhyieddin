import React from "react";

const Comment = ({ comment }) => {
  return (
    <div className="comment-container">
      <p>{comment.name}</p>
    </div>
  );
};

export default Comment;
