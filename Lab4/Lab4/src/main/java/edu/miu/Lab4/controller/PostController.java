package edu.miu.Lab4.controller;

import edu.miu.Lab4.domain.Comment;
import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.dto.PostDTO;
import edu.miu.Lab4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDTO){
        postService.addPost(postDTO);
        return new ResponseEntity<>("Post added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id){
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO){
        postService.updatePost(id, postDTO);
        return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
    }

    @GetMapping("/filter")
    public List<Post> findByAuthorName(@RequestParam String author){
        return postService.findByAuthorName(author);
    }

    @GetMapping("/title/{title}")
    public List<Post> findAllPostFromGivenTitle(@PathVariable String title){
        return postService.findByGivenTitle(title);
    }

    @GetMapping("/createException")
    public ResponseEntity<String> createException(){
        postService.createException();
        return new ResponseEntity<>("Exception is created", HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getCommentList(@PathVariable Long id){
        return List.of(new Comment(1,"Some comment"));
    }
}
