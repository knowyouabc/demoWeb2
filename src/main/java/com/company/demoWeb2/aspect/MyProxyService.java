package com.company.demoWeb2.aspect;
import org.aspectj.lang.ProceedingJoinPoint;


public class MyProxyService {

    public Object aroundProxyMethod(ProceedingJoinPoint pjp) {
        Object re = null;
        try {
            System.out.println("前置通知");
            re = pjp.proceed();//业务逻辑
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }
        return re;
    }
}
