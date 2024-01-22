package edu.miu.Lab4.advice.execution;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class ExecutionTimeAspect {

    @Around("@annotation(ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(
                "Method: " + joinPoint.getSignature().toShortString() +
                        " | Execution Time: " + executionTime + "ms"
        );
        return proceed;
    }
}
