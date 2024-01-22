package edu.miu.Lab4.controller;

import edu.miu.Lab4.domain.Comment;
import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.User;
import edu.miu.Lab4.domain.dto.UserDTO;
import edu.miu.Lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return new ResponseEntity<>("Post added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getAllPostFromUser(@PathVariable Long id){
        return userService.getAllPostFromUser(id);
    }

    @GetMapping("postGreaterThan/{num}")
    public List<User> getUsersPostGreaterThan(@RequestParam(required = false) Integer num) {
        if (num == null) {
            return userService.findAll();
        } else {
            return userService.findGreaterThan(num.intValue());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id){
        userService.deletePostById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/postTitle/{title}")
    public List<User> findUserByPostTitle(@PathVariable String title){
        return userService.findUserByPostTitle(title);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public Comment getUserFromCommentId(@PathVariable long commentId,
                                        @PathVariable long postId,
                                        @PathVariable long userId){
        return userService.getUserFromCommentId(userId, postId, commentId);
    }
}
