package edu.miu.Lab2.repository;


import edu.miu.Lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(String author);
//    List<Post> findAll();
//    Post findById(long id);
//    void save(Post post);
//    void deleteById(long id);
//
//    Post updatePost(Long id, Post post);
//    List<Post> findByAuthor(String author);
}
