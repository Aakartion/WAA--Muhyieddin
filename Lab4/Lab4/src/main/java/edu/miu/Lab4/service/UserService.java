package edu.miu.Lab4.service;

import edu.miu.Lab4.domain.Comment;
import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.User;
import edu.miu.Lab4.domain.dto.UserDTO;

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
