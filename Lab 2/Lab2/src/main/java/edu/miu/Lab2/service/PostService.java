package edu.miu.Lab2.service;

import edu.miu.Lab2.domain.Post;
import edu.miu.Lab2.domain.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    void addPost(PostDTO postDTO);
    Post getPostById(Long id);

    void deletePostById(Long id);

    Post updatePost(Long id, PostDTO postDTO);

    List<Post> findByAuthorName(String author);
}
