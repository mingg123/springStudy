package com.example.aop.parameter;


import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


//Aop로 쓰려면 aspect써줘야함 
@Aspect
@Component
public class ParameterAop {
    
    //Pointcut을 붙여야함
    @Pointcut("execution(* com.example.aop.Controller..*.*(..))")
    private void cut() {

    }

    @Before("cut()") //cut이 실행되는 시점에 해당 메소드를 실행시켜라
    public void before(JoinPoint JoinPoint) {
        MethodSignature methodSignature = (MethodSignature) JoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = JoinPoint.getArgs();

       
        for(Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning="returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
   
    }
}
