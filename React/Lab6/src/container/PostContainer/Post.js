import React from "react";
import "./Post.css";
import PostDetailContainer from "./PostDetailContainer";

function Post() {
  const posts = [
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" },
  ];

  return (
    <div>
      <div className="postContainer">
        {posts.map((post) => (
          <div key={post.id} id="postId">
            <p>Id: {post.id}</p>
            <p>Title: {post.title}</p>
            <p>Author: {post.author}</p>
          </div>
        ))}
      </div>
      <PostDetailContainer />
    </div>
  );
}

export default Post;
