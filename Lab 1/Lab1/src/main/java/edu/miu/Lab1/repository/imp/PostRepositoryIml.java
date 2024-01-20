package edu.miu.Lab1.repository.imp;

import edu.miu.Lab1.domain.Post;
import edu.miu.Lab1.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryIml implements PostRepository {

    private static List<Post> posts = new ArrayList<>();

    static {
        Post p1 = new Post(1L,"Spring-React","Learning Spring on backend and React on Front end","John Doe");
        Post p2 = new Post(2L, "AWS", "Learning AWS cloud services","Hanna Smith");
        posts.add(p1);
        posts.add(p2);
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    @Override
    public Post findById(long id) {
        for (Post post: posts){
            if(post.getId() == id){
                return post;
            }
        }
        return null;
    }

    @Override
    public void save(Post post) {
        posts.add(post);
    }

    @Override
    public void deleteById(long id) {
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    @Override
    public Post updatePost(Long id ,Post post) {
        for (Post storedPost: posts){
            if(storedPost.getId().equals(id)){
                storedPost.setTitle(post.getTitle());
                storedPost.setAuthor(post.getAuthor());
                storedPost.setContent(post.getContent());
                return storedPost;
            }
        }
        return null;
    }

    public List<Post> findByAuthorName(String author){
        return posts.stream()
                .filter(post-> post.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
