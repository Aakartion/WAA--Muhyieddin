package edu.miu.Lab4.advice.exception;

import edu.miu.Lab4.domain.ExceptionEntity;
import edu.miu.Lab4.repository.ExceptionRepository;
import edu.miu.Lab4.utility.Utility;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Aspect
public class ExceptionAspect {
    private final ExceptionRepository exceptionRepository;

    public ExceptionAspect(ExceptionRepository exceptionRepository){
        this.exceptionRepository = exceptionRepository;
    }

    @AfterThrowing(
            pointcut = "execution(* edu.miu.Lab4.service.PostService.createException(..))",
            throwing = "exception"
    )
    public void logException(JoinPoint joinPoint, Exception exception){
        String methodName = joinPoint.getSignature().getName();
        String principle = "FakePrinciple";

        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setExceptionType(exception.getClass().getName());
        exceptionEntity.setTransactionId(Utility.generateTransactionId());
        exceptionEntity.setDate(LocalDate.now());
        exceptionEntity.setTime(LocalTime.now());
        exceptionEntity.setPrinciple(principle);
        exceptionEntity.setOperation(methodName);
        exceptionRepository.save(exceptionEntity);
    }
}
