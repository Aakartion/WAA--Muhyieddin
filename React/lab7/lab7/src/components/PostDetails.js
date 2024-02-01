import axios from "axios";
import React, { useEffect, useState } from "react";

const PostDetails = ({ postId }) => {
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

  if (!post) {
    return <p>Loading...</p>;
  }
  return (
    <div className="post-details">
      <h2>{post.title}</h2>
      {/* <p>{post.body}</p> */}
      <p>Author: {post.author}</p>
      <button>Delete Post</button>
    </div>
  );
};

export default PostDetails;
