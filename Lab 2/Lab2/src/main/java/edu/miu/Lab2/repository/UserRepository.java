package edu.miu.Lab2.repository;

import edu.miu.Lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where size(u.posts) > :num")
    List<User> findGreaterThan(int num);
}
