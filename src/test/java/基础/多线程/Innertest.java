package 基础.多线程;

/**
 * @program springbootcachedemo
 * @description: 面试
 * @author: xielinzhi
 * @create: 2019/05/11 22:51
 */
/*
请使用内部类实现线程设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。
 */
public class Innertest{

    public static int j = 0;

    class Mythread  extends Thread{
        @Override
        public void run() {
           jd();
        }
    }
    class Mythread2 extends Thread{
        @Override
        public void run() {
            ja();
        }
    }
    public static void main(String[] args) throws Exception {
        Innertest innertest = new Innertest();
        Mythread mythread = innertest.new Mythread();
        mythread.start();

        Mythread2 mythread2 = innertest.new Mythread2();
        mythread2.start();
    }

    public synchronized static void jd(){
        j--;System.out.println(j);
    }

    public synchronized static void ja(){
        j++;System.out.println(j);
    }
}
