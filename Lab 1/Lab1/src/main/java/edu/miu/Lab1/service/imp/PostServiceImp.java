package edu.miu.Lab1.service.imp;

import edu.miu.Lab1.domain.Post;
import edu.miu.Lab1.domain.adapter.PostAdapter;
import edu.miu.Lab1.domain.dto.PostDTO;
import edu.miu.Lab1.repository.PostRepository;
import edu.miu.Lab1.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void addPost(PostDTO postDTO) {
        Post post = PostAdapter.getPost(postDTO);
        postRepository.save(post);
    }

    public Post getPostById(Long id){
        return postRepository.findById(id);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Long id, PostDTO postDTO) {
        Post post = PostAdapter.getPost(postDTO);
        Post updatedPost = postRepository.updatePost(id , post);
        return updatedPost;
    }

    @Override
    public List<Post> findByAuthorName(String author) {
        return postRepository.findByAuthorName(author);
    }
}
