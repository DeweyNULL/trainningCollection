package LEETCODE.按序打印1114;

import org.junit.Test;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program testCollections
 * @description: 题目
 * @author: xielinzhi
 * @create: 2019/09/08 09:28
 */


public class 多线程斐波那契数列 {


    AtomicInteger version = new AtomicInteger(0);
    int times = 0;
    int totalTimes = 20;
    long f0 = 0;
    long f1 = 1;
    long f2;

    @Test
    public void testThead(){
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(version.compareAndSet(0,3)){
                        if(times>totalTimes){
                            break;
                        }
                        times ++;
                        f2 = f1 + f0;
                        f0 = f1;
                        f1 = f2;
                        System.out.println(Thread.currentThread().getName()+":"+f2);
                        version.set(1);
                    }
                }
            }
        },"ThreadA");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(version.compareAndSet(1,3)){
                        if(times>totalTimes){
                            break;
                        }
                        times ++;
                        f2 = f1 + f0;
                        f0 = f1;
                        f1 = f2;
                        System.out.println(Thread.currentThread().getName()+":"+f2);
                        version.set(2);
                    }
                }
            }
        },"ThreadB");
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(version.compareAndSet(2,3)){
                        if(times>totalTimes){
                            break;
                        }
                        times ++;
                        f2 = f1 + f0;
                        f0 = f1;
                        f1 = f2;
                        System.out.println(Thread.currentThread().getName()+":"+f2);
                        version.set(0);
                    }
                }
            }
        },"ThreadC");

        threadA.start();
        threadB.start();
        threadC.start();
    }

}
