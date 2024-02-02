import React, { useEffect, useState } from "react";
import Posts from "../../components/Post/Posts";
import "./Dashboard.css";
import "./InputField.css";
import axios from "axios";
import PostDetails from "../../components/Post/PostDetails";
import AddPost from "../../components/Add/AddPost";

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [selectedPostId, setSelectedPostId] = useState(null);
  const [isAddPostOpen, setIsAddPostOpen] = useState(false);

  const fetchPosts = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/v1/posts");
      setPosts(response.data);
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const onAddPost = (newPost) => {
    setPosts((prevPosts) => [...prevPosts, newPost]);
    setIsAddPostOpen(false); // Close the AddPost component
  };

  const onDeletePost = (deletedPostId) => {
    setPosts((prevPosts) =>
      prevPosts.filter((post) => post.id !== deletedPostId)
    );
    setSelectedPostId(null);
  };

  const updateFirstPostTitle = (newTitle) => {
    const updatedPosts = [...posts];
    updatedPosts[0].title = newTitle;
    setPosts(updatedPosts);
  };

  const onSelectPost = (postId) => {
    const post = posts.find((p) => p.id === postId);
    setSelectedPostId(post.id);
  };

  return (
    <div className="dashboard-container">
      <h1>Lab7 Application</h1>
      <button onClick={() => setIsAddPostOpen(true)}>Add Post</button>
      <Posts
        posts={posts}
        updateFirstPostTitle={updateFirstPostTitle}
        onSelectPost={onSelectPost}
      />
      <h3>Provide your input</h3>
      <input
        className="inputFiled"
        type="text"
        placeholder="New Title"
        onChange={(e) => updateFirstPostTitle(e.target.value)}
      />
      {selectedPostId && (
        <PostDetails
          postId={selectedPostId}
          onDeletePost={onDeletePost}
          onClose={() => setSelectedPostId(null)}
        />
      )}
      {isAddPostOpen && (
        <AddPost
          onAddPost={onAddPost}
          onClose={() => setIsAddPostOpen(false)}
        />
      )}
    </div>
  );
};
export default Dashboard;
