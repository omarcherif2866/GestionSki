package com.example.gestionski_omarcherif.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Before("execution( * com.example.gestionski_omarcherif.services.*.*(..))")
    public void logInMethod(JoinPoint joinPoint){

        log.info("in method " + joinPoint.getSignature().getName());
    }

    @After("execution( * com.example.gestionski_omarcherif.services.*.*(..))")
    public void logOutOfMethod(JoinPoint joinPoint){

        log.info("Out Of method " + joinPoint.getSignature().getName());
    }

}
