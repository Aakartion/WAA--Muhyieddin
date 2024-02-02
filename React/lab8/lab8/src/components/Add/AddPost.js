import React, { useRef } from "react";
import axios from "axios";

const AddPost = ({ onAddPost, onClose, setFlag }) => {
  const formRef = useRef();

  const handleAddPost = async () => {
    try {
      const formData = Object.fromEntries(new FormData(formRef.current));
      // Send a POST request to add a new post
      const response = await axios.post(
        "http://localhost:8080/api/v1/posts",
        formData
      );

      // Notify the parent component to update the posts
      onAddPost(response.data);
      setFlag((flag) => !flag);

      // Close the AddPost component
      onClose();
    } catch (error) {
      console.error("Error adding post:", error);
    }
  };

  return (
    <form
      ref={formRef}
      onSubmit={(e) => {
        e.preventDefault();
      }}
      className="add-post"
    >
      <h2>Add Post</h2>
      <label>Title:</label>
      <input name="title" type="text" />
      <label>Author:</label>
      <input name="author" type="text" />

      <label>Content:</label>
      <button onClick={handleAddPost}>Add Post</button>
      <button onClick={onClose}>Cancel</button>
    </form>
  );
};

export default AddPost;
