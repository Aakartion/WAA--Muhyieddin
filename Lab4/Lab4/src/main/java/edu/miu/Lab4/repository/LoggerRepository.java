package edu.miu.Lab4.repository;

import edu.miu.Lab4.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
