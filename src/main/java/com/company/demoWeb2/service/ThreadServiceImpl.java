package com.company.demoWeb2.service;

import com.company.demoWeb2.entity.Person;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void runThread() throws ExecutionException, InterruptedException {
        Semaphore semaphore = new Semaphore(2);//信号量，限流，只允许2个线程
        CountDownLatch latch = new CountDownLatch(2);//计数器，必须2个线程都完成
        Future<Person> f1 = threadPoolTaskExecutor.submit(new AsynService("线程1", 1000, latch, semaphore));
        Future<Person> f2 = threadPoolTaskExecutor.submit(new AsynService("线程2", 10000, latch, semaphore));
        boolean await = latch.await(30, TimeUnit.SECONDS);
        Person p1 = f1.get();
        Person p2 = f2.get();


        int threadNum = 5;
        //循环栅栏，每次barrier.await()则barrier减1并等待，直到barrier清零恢复再继续下一次循环
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "最后完成，barrier从0恢复到" + threadNum);
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new CyclicBarrierThread("线程"+i, barrier).start();
        }
    }

    public class CyclicBarrierThread extends Thread {

        private CyclicBarrier barrier;

        CyclicBarrierThread(String name, CyclicBarrier barrier) {
            this.setName(name);
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                doCyclicBarrier();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private Person doCyclicBarrier() throws InterruptedException, BrokenBarrierException {

            System.out.println("开始：" + this.getName());
            Thread.sleep(1000);
            System.out.println(this.getName() + "完成，barrier次数减少一次并等待");//等待barrier数量减到0，并恢复初始数量
            barrier.await();

            System.out.println("开始：" + this.getName());
            Thread.sleep(1000);
            System.out.println(this.getName() + "完成，barrier数量减少一次并等待");//等待barrier数量减到0，并恢复初始数量
            barrier.await();

            return new Person();
        }
    }

}
