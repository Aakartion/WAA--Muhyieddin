package edu.miu.Lab4.domain.adapter;

import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.dto.PostDTO;

public class PostAdapter {
    public static Post getPost(PostDTO postDTO){
        return new Post(
                postDTO.getId(),
                postDTO.getTitle(),
                postDTO.getContent(),
                postDTO.getAuthor(),
                CommentAdapter.getComments(postDTO.getComments())
                );
    }

    public static PostDTO getPostDTO(Post post){
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                CommentAdapter.getCommentDTOs(post.getComments())
        );
    }
}
