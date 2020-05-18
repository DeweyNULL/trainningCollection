package 基础.多线程;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 * @author: xielinzhi
 * @create: 2019/05/11 15:51
 */

class Ticket extends Thread{
    String name;
    int ticketNum = 100;
    Ticket(String name){
       this.name = name;
    }

    @Override
    public void run() {
        while (true){
        synchronized (this){
            notifyAll();
            if(ticketNum>0){
                System.out.println(name+"卖掉了第"+ticketNum+"张票");
                ticketNum--;
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else break;

        }
        }

    }
}
class Communication implements Runnable {
    int i = 1;

    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;

            }
        }
    }
}
public class Test3 implements Runnable{

    int i = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;

            }
        }
    }

    public static void main(String[] args) {
        /*只有一个TestThread对象*/
        Test3 t = new Test3();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }

    @Test
    public void test3(){
        Thread thread = new Ticket("A");
        thread.start();

    }

}
