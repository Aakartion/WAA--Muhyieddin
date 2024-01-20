package edu.miu.Lab3.service.imp;

import edu.miu.Lab3.domain.Comment;
import edu.miu.Lab3.domain.Post;
import edu.miu.Lab3.domain.User;
import edu.miu.Lab3.domain.adapter.UserAdapter;
import edu.miu.Lab3.domain.dto.UserDTO;
import edu.miu.Lab3.repository.UserRepository;
import edu.miu.Lab3.service.UserService;
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

    @Override
    public void deletePostById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findUserByPostTitle(String title) {
        return userRepository.findUsersByPostTitle(title);
    }

    @Override
    public Comment getUserFromCommentId(Long commentId, Long postId, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Optional<Post> postOptional = user.getPosts()
                    .stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst();
            if(postOptional.isPresent()) {
                Post post = postOptional.get();

                Optional<Comment> commentOptional = post.getComments()
                        .stream()
                        .filter(comment -> comment.getId() == commentId)
                        .findFirst();
                if(commentOptional.isPresent()){
                    Comment comment = commentOptional.get();
                    return comment;
                }
                return null;
            }
            return null;
        }
        return null;

    }


}
