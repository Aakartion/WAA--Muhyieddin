package edu.miu.Lab4.repository;

import edu.miu.Lab4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where size(u.posts) > :num")
    List<User> findGreaterThan(int num);

    @Query("SELECT DISTINCT u FROM User u WHERE u.id IN (SELECT DISTINCT u.id FROM User u JOIN u.posts p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%')))")
    List<User> findUsersByPostTitle(@Param("title") String title);

    Optional<User> findByName(String name);

}
