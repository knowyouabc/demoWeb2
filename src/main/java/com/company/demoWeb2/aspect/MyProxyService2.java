package com.company.demoWeb2.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyProxyService2 {

    @Pointcut("execution(* *..*.PersonService.*(..))")
    private void MyPt() {}

    @Around("MyPt()")
    public Object aroundProxyMethod(ProceedingJoinPoint pjp) {
        Object re = null;
        try {
            System.out.println("前置通知");
            re = pjp.proceed();//业务逻辑
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
        return re;
    }
}
