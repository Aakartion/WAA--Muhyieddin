package edu.miu.Lab4.service.imp;

import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.adapter.PostAdapter;
import edu.miu.Lab4.domain.dto.PostDTO;
import edu.miu.Lab4.repository.PostRepository;
import edu.miu.Lab4.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Long id, PostDTO postDTO) {
        Post post = PostAdapter.getPost(postDTO);
        Optional<Post> existedPostOptional = postRepository.findById(id);
        if(existedPostOptional.isPresent()){
            Post existedPost = existedPostOptional.get();
            existedPost.setAuthor(post.getAuthor());
            existedPost.setTitle(post.getTitle());
            existedPost.setContent(post.getContent());
            existedPost.setComments(post.getComments());
            return postRepository.save(existedPost);
        }else
            return null;
    }

    @Override
    public List<Post> findByAuthorName(String author) {
        return postRepository.findByAuthor(author);
    }

    @Override
    public List<Post> findByGivenTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public void createException() {
        throw new RuntimeException("This is a simulated exception.");
    }
}
