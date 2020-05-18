package 基础.多线程;

/**
 * @program springbootcachedemo
 * @description: 继承Thread类
 * @author: xielinzhi
 * @create: 2019/05/05 12:32
 */

public class ThreadMethod extends Thread {

    @Override
    public void run() {
        System.out.println("子线程");
        try {
            Thread.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ThreadMethod threadMethod = new ThreadMethod();

        System.out.println("主线程");

        threadMethod.start();

        System.out.println("主线程");

    }
}
