package edu.miu.Lab2.domain.adapter;

import edu.miu.Lab2.domain.Post;
import edu.miu.Lab2.domain.dto.PostDTO;

public class PostAdapter {
    public static Post getPost(PostDTO postDTO){
        return new Post(
                postDTO.getId(),
                postDTO.getTitle(),
                postDTO.getContent(),
                postDTO.getAuthor()
                );
    }

    public static PostDTO getPostDTO(Post post){
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor()
        );
    }
}
