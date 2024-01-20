package edu.miu.Lab2.databaseLoader;

import edu.miu.Lab2.domain.Post;
import edu.miu.Lab2.domain.User;
import edu.miu.Lab2.repository.PostRepository;
import edu.miu.Lab2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Post p1 = new Post(2000L, "Spring-React And SQL", "Learning Spring on backend and React on Front end", "John Doe");
        Post p2 = new Post(223423423L, "AWS", "Learning AWS cloud services", "Hanna Smith");

        Post p3 = new Post(3L, "Snow", "Snowing today", "Josep Doe");
        Post p4 = new Post(4L, "Rain", "Raining today", "Jane Smith");
        List<Post> postList1 = new ArrayList<>();
        List<Post> postList2 = new ArrayList<>();
        postList1.add(p1);
        postList1.add(p2);
        postList2.add(p3);
        postList2.add(p4);
        User u1 = new User(1L,"Anne Frank", postList1);
        User u2 = new User(2L,"Leonel Messi", postList2);
        userRepository.save(u1);
        userRepository.save(u2);
//        postRepository.save(p1);
//        postRepository.save(p2);

    }
}
