package 基础.多线程.线程池;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program testCollections
 * @description: 死磕线程池
 * @author: xielinzhi
 * @create: 2019/07/20 16:17
 */

public class ThreadPoolTest {

    @Test
    public void threadPoolCreate(){
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,3000);
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> testTask = new ArrayList<>();
        testTask.add(new Task());
        List<Future<Integer>> future ;
        try {
            future = service.invokeAll(testTask);
            for (Future<Integer> temp: future) {
                temp.get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}


class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("into task");
        int i = 1/0;
        System.out.println(i);
        return 1;
    }
}
