package 基础.多线程;

import org.junit.Test;

import java.util.Random;

/**
 * @program springbootcachedemo
 * @description:
 * @author: xielinzhi
 * @create: 2019/05/11 16:20
 */
class Rabbit implements Runnable{
    int race = 100;

    @Override
    public void run() {
        Random random = new Random();
        while (race>0){
            int run = random.nextInt(race);
            if(run==0) break;
            race-=run;
            System.out.println("rabbit has run " + run+" m");
        }
    }
}
public class Test4 {

    @Test
    public void test4(){
        System.out.println(Math.random());
        Random random = new Random();
        System.out.println(random.nextInt(101));
    }

    @Test
    public void runtest(){
        Rabbit rabbit = new Rabbit();
        new Thread(rabbit).setPriority(Thread.MAX_PRIORITY);

    }
}
