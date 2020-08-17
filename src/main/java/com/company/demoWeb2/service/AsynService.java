package com.company.demoWeb2.service;

import com.company.demoWeb2.entity.Person;

import java.util.concurrent.*;

public class AsynService implements Callable {

    private String name;

    private long sleep;

    private CountDownLatch latch;

    private Semaphore semaphore;

    AsynService(String name, long sleep, CountDownLatch latch, Semaphore semaphore) {
        this.name = name;
        this.sleep = sleep;
        this.latch = latch;
        this.semaphore = semaphore;
    }

    @Override
    public Person call() throws Exception {

        doSemaphore();
        doLatch();

        return new Person();
    }

    private Person doSemaphore() throws InterruptedException {
        semaphore.acquire();//获取许可

        System.out.println("开始："+name);
        Thread.sleep(sleep);
        System.out.println("结束："+name);

        semaphore.release();//释放限制

        return new Person();
    }

    private Person doLatch() throws InterruptedException {

        System.out.println("开始："+name);
        Thread.sleep(sleep);
        System.out.println("结束："+name);

        latch.countDown();//执行完毕

        return new Person();
    }
}
