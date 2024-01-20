package edu.miu.Lab1.controller;

import edu.miu.Lab1.domain.Post;
import edu.miu.Lab1.domain.dto.PostDTO;
import edu.miu.Lab1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

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
    public ResponseEntity<String> updatePost(@PathVariable long id, @RequestBody PostDTO postDTO){
        postService.updatePost(id, postDTO);
        return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
    }

    @GetMapping("/{author}")
    public List<Post> findByAuthorName(@PathVariable String author){
        return postService.findByAuthorName(author);
    }
}
