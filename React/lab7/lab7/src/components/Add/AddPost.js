import React, { useState } from "react";
import axios from "axios";

const AddPost = ({ onAddPost, onClose }) => {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");

  const handleAddPost = async () => {
    try {
      // Send a POST request to add a new post
      const response = await axios.post("http://localhost:8080/api/v1/posts", {
        title,
        author,
      });

      // Notify the parent component to update the posts
      onAddPost(response.data);

      // Close the AddPost component
      onClose();
    } catch (error) {
      console.error("Error adding post:", error);
    }
  };

  return (
    <div className="add-post">
      <h2>Add Post</h2>
      <label>Title:</label>
      <input
        type="text"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <label>Author:</label>
      <input
        type="text"
        value={author}
        onChange={(e) => setAuthor(e.target.value)}
      />
      <label>Content:</label>
      <button onClick={handleAddPost}>Add Post</button>
      <button onClick={onClose}>Cancel</button>
    </div>
  );
};

export default AddPost;
