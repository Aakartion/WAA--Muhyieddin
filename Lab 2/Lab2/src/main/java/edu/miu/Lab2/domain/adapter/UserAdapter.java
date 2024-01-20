package edu.miu.Lab2.domain.adapter;

import edu.miu.Lab2.domain.User;
import edu.miu.Lab2.domain.dto.UserDTO;

public class UserAdapter {
    public static User getUserDTO(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getPosts()
        );
    }

    public static UserDTO getUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getPosts()
        );
    }
}
