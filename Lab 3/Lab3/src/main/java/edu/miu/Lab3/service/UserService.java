package edu.miu.Lab3.service;

import edu.miu.Lab3.domain.Comment;
import edu.miu.Lab3.domain.Post;
import edu.miu.Lab3.domain.User;
import edu.miu.Lab3.domain.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void addUser(UserDTO userDTO);
    User getUserById(Long id);

    List<Post> getAllPostFromUser(Long id);

    List<User> findGreaterThan(int num);

    void deletePostById(Long id);

    List<User> findUserByPostTitle(String title);

    Comment getUserFromCommentId(Long commentId, Long postId, Long userId);

}
