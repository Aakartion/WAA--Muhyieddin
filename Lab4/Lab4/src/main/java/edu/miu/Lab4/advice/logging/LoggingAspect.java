package edu.miu.Lab4.advice.logging;

import edu.miu.Lab4.domain.Logger;
import edu.miu.Lab4.repository.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Aspect
@Component
public class LoggingAspect {
    private final LoggerRepository loggerRepository;

    public LoggingAspect(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Pointcut("execution(* edu.miu.Lab4.service.*.*(..))")
    private void serviceMethods() {
    }

    public void logServiceMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        String principle = "FakeStaticUser";

        Logger logger = new Logger();
        logger.setTransactionId(generateTransactionId());
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple(principle);
        logger.setOperation(methodName);
        loggerRepository.save(logger);
    }

    public String generateTransactionId(){
        return LocalDateTime.now().toString();
    }
}
