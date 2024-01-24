package edu.miu.Lab4.databaseLoader;

import edu.miu.Lab4.domain.Comment;
import edu.miu.Lab4.domain.Post;
import edu.miu.Lab4.domain.Role;
import edu.miu.Lab4.domain.User;
import edu.miu.Lab4.repository.CommentRepository;
import edu.miu.Lab4.repository.PostRepository;
import edu.miu.Lab4.repository.UserRepository;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Comment c1 = new Comment(122333, "@John Doe");
        Comment c2 = new Comment(122334, "@Danny Jane");
        Comment c3 = new Comment(122335, "@John Doe");
        Comment c4 = new Comment(122336, "@Danny Jane");
        List<Comment> commentList1 = new ArrayList<>();
        List<Comment> commentList2 = new ArrayList<>();
        commentList1.add(c1);
        commentList1.add(c2);
        commentList2.add(c3);
        commentList2.add(c4);
        Post p1 = new Post(2000L, "Spring-React And SQL", "Learning Spring on backend and React on Front end", "John Doe", commentList1);
        Post p2 = new Post(223423423L, "AWS", "Learning AWS cloud services", "Hanna Smith", commentList2);

        Post p3 = new Post(3L, "Snow", "Snowing today", "Josep Doe", commentList1);
        Post p4 = new Post(4L, "Rain", "Raining today", "Jane Smith", commentList2);
        List<Post> postList1 = new ArrayList<>();
        List<Post> postList2 = new ArrayList<>();
        postList1.add(p1);
        postList1.add(p2);
        postList2.add(p3);
        postList2.add(p4);
        Role r1 = new Role(1,"Admin");
        Role r2 = new Role(1,"User");
        List<Role> roleList1 = new ArrayList<>();
        List<Role> roleList2 = new ArrayList<>();
        roleList1.add(r1);
        roleList2.add(r1);
        roleList2.add(r2);

        User u1 = new User(1L,"Anne Frank", "123",roleList1,postList1);
        User u2 = new User(1L,"Janne Frank", "223",roleList2,postList2);
        userRepository.save(u1);
        userRepository.save(u2);
    }

}
