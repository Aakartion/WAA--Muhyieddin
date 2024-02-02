import axios from "axios";
import React, { useEffect, useState } from "react";
import "./PostDetails.css";
import Comment from "./../Commnet/Comment";

const PostDetails = ({ postId, onDeletePost, onClose }) => {
  const [post, setPost] = useState(null);
  const [comments, setComments] = useState([]);

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

  useEffect(() => {
    const fetchPostAndComments = async () => {
      try {
        // Fetch post details
        const postResponse = await axios.get(
          `http://localhost:8080/api/v1/posts/${postId}`
        );
        setPost(postResponse.data);

        // Fetch comments for the post
        const commentsResponse = await axios.get(
          `http://localhost:8080/api/v1/posts/${postId}/comments`
        );
        setComments(commentsResponse.data);
      } catch (error) {
        console.error("Error fetching post details and comments:", error);
      }
    };

    fetchPostAndComments();
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
        <h3>Comments:</h3>
        {comments.map((comment) => (
          <Comment key={comment.id} comment={comment} />
        ))}
      </div>
      <button onClick={handleDelete}>Delete</button>
      <button onClick={onClose}>Close</button>
    </div>
  );
};

export default PostDetails;
