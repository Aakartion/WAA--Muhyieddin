package edu.miu.Lab2.service.imp;

import edu.miu.Lab2.domain.Post;
import edu.miu.Lab2.domain.User;
import edu.miu.Lab2.domain.adapter.UserAdapter;
import edu.miu.Lab2.domain.dto.UserDTO;
import edu.miu.Lab2.repository.UserRepository;
import edu.miu.Lab2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void addUser(UserDTO userDTO) {
        User user = UserAdapter.getUserDTO(userDTO);
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPostFromUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return user.getPosts();
        }
        else
            return null;
    }

    @Override
    public List<User> findGreaterThan(int num){
        return userRepository.findGreaterThan(num);
    }

}
