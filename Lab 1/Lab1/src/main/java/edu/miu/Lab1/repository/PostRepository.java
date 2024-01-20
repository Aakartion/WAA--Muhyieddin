package edu.miu.Lab1.repository;


import edu.miu.Lab1.domain.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findById(long id);
    void save(Post post);
    void deleteById(long id);

    Post updatePost(Long id, Post post);
    List<Post> findByAuthorName(String author);
}
