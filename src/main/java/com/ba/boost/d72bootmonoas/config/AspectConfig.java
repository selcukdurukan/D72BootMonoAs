package com.ba.boost.d72bootmonoas.config;

import com.ba.boost.d72bootmonoas.exception.CartServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

    private final Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Around(value = "execution(* com.ba.boost.d72bootmonoas.service.*.*(..))")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {

        Long startTime = System.currentTimeMillis();

        try {
            Object obj = joinPoint.proceed();
            Long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Time taken by {} is {}", joinPoint, timeTaken);
            return obj;
        } catch (CartServiceException e) {
            log.error("Exception message: {}", e.getErrorType().getMessage());
            log.error("Exception status: {}", e.getErrorType().getHttpStatus());
            throw e;
        }
    }
}