package edu.miu.Lab4.service.imp;

import edu.miu.Lab4.advice.execution.ExecutionTime;
import edu.miu.Lab4.domain.Comment;
import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.User;
import edu.miu.Lab4.domain.dto.UserDTO;
import edu.miu.Lab4.repository.UserRepository;
import edu.miu.Lab4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
    }

    @ExecutionTime
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
