package com.examly.springapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class loginaspect {
    @Before("execution(* com.examly.springapp.service.*.*(..))")
    public void beforeServiceMethods() {
        System.out.println("Service method execution started");
    }

    @After("execution(* com.examly.springapp.service.*.*(..))")
    public void afterServiceMethods() {
        System.out.println("Service method execution completed");
    }
}
