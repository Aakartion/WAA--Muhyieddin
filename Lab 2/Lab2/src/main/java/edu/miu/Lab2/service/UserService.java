package edu.miu.Lab2.service;

import edu.miu.Lab2.domain.Post;
import edu.miu.Lab2.domain.User;
import edu.miu.Lab2.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void addUser(UserDTO userDTO);
    User getUserById(Long id);

    List<Post> getAllPostFromUser(Long id);

    List<User> findGreaterThan(int num);

}
