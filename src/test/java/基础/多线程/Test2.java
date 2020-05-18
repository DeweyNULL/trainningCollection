package 基础.多线程;

/**
 * @program springbootcachedemo
 * @description: 编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，生产10台电视机，一边生产一边销售（消费）。
 * @author: xielinzhi
 * @create: 2019/05/11 15:29
 */


class Store{
    public int MaxNum = 4;
    public int num = 0;
    public int times = 0;

    public synchronized void product(){
        if(num>=MaxNum){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            num++;
            System.out.println("生产了第"+num+"个商品");
            notifyAll();
        }
    }

    public synchronized void sell(){
        if(num<=0){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            num--;
            System.out.println("卖掉了"+num+"个商品");
            notifyAll();
        }
    }
}

class Productor implements Runnable{

    int num = 0;
    Store store;
    Productor(Store temp){
        store = temp;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {

            System.out.println("生产者第"+i+"次生产");
            store.product();
            try {
                Thread.sleep((int)(Math.random()*100));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    Store store;
    int num = 0;
    Consumer(Store temp){
        store = temp;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("消费者第"+num+"次消费");
            num++;
            store.sell();
            try {
                Thread.sleep((int)(Math.random()*100));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        Store store = new Store();

        new Thread(new Productor(store)).start();
        new Thread(new Consumer(store)).start();
    }
}
