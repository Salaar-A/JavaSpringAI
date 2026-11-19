package com.ecitcarp.practicespringboot.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.ecitcarp.practicespringboot.controller.*.*(..)) && !execution(* com.ecitcarp.practicespringboot.filter.*.*(..))")
    public void allClassesMethods(){}

    @Before("allClassesMethods()")
    public void beforeMethods(JoinPoint jp){
        log.info("Before the method calling -------------------------{}", jp.getSignature().getName());
    }

    @After("allClassesMethods()")
    public void afterMethods(JoinPoint jp){
        log.info("After the method has called-------------------------{}",jp.getSignature().getName());
    }
}
