package edu.miu.Lab4.repository;

import edu.miu.Lab4.domain.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends JpaRepository<ExceptionEntity, Long> {
}
