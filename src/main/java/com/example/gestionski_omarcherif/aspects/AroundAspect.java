package com.example.gestionski_omarcherif.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/* @Slf4j
@Component
@Aspect
public class AroundAspect {

    @Around("execution( * com.example.gestionski_omarcherif.services.*.*(..))")
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        long t1 = System.currentTimeMillis();
        Object obj = pjp.proceed();
        //List<Object> obj =new ArrayList<Object>();
        long executionTime = System.currentTimeMillis() - t1;
        String methodeName= pjp.getSignature().getName();
        log.info("The runtime of the methode (" + methodeName +")=" + executionTime + "ms");
        return obj;
    }
}


 */
