import axios from "axios";
import React, { useEffect, useState } from "react";
import "./PostDetails.css";

const PostDetails = ({ postId, onDeletePost, onClose }) => {
  const [post, setPost] = useState(null);

  useEffect(() => {
    const fetchDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/v1/posts/${postId}`
        );
        setPost(response.data);
      } catch (error) {
        console.log("Error fetching details", error);
      }
    };
    fetchDetails();
  }, [postId]);

  const handleDelete = async () => {
    try {
      axios.delete(`http://localhost:8080/api/v1/posts/${postId}`);
      onDeletePost(postId);
      onClose();
    } catch (error) {
      console.error("Error deleting post:", error);
    }
  };

  if (!post) {
    return <p>Loading...</p>;
  }
  return (
    <div>
      <div className="post-details">
        <h3>Id: {post.id}</h3>
        <h3>Title: {post.title}</h3>
        <h3>Author: {post.author}</h3>
      </div>
      <button onClick={handleDelete}>Delete</button>
      <button onClick={onClose}>Close</button>
    </div>
  );
};

export default PostDetails;
