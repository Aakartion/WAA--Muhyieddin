package edu.miu.Lab3.repository;


import edu.miu.Lab3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(String author);

    List<Post> findByTitle(String title);
}
