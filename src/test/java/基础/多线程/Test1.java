package 基础.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program springbootcachedemo
 * @description: 创建两个分线程，让其中一个线程输出1-100之间的偶数，
 * 另一 个线程输出1-100之间的奇数
 * @author: xielinzhi
 * @create: 2019/05/11 14:34
 */

public class Test1 {

    volatile static int num = 100;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    while (num>0){
                    notify();
                    System.out.println(num);
                    numdecrise();
                    try {
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }
                }

            }
        });

        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    while (num>0){
                    notify();
                    System.out.println(num);
                    numdecrise();
                    try {
                        wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }
                }
            }
        }).start();

        Executors.newFixedThreadPool(10);
    }

    public static void numdecrise(){
        num--;
    }
}
