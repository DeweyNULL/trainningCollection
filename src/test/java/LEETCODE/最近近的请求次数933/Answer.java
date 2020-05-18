package LEETCODE.最近近的请求次数933;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2019/11/20 16:50
 */

/**
 *  题目描述：
 *  写一个 RecentCounter 类来计算最近的请求。
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 * 返回从 3000 毫秒前到现在的 ping 数。
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目解析：
 * JAVA 实现： 利用队列(FIFO, 先进先出) 进行实现。题目说的是，在时间点 t 进行一次 ping 操作，
 * 加上之前在 [t-3000, t] 范围内的 ping 操作的次数，并将次数返回。例如，例子中第一次 ping 的 t = 1，
 * 返回 1；第二次 ping 的 t = 100, 第一次 ping 的时间点 1 在本次允许范围 [100-3000, 100] 之内，
 * 所以返回2；第三次 ping 时，前两次的 ping 都在允许范围[3000-3000, 3000] 之内，所以返回 3；
 * 第四次 ping 时，第一次 ping 的 t = 1 不在允许范围[3002-3000, 3000] 之内，所以返回 3。
 * 利用队列先进先出的特点，移除当次 ping 操作不在允许范围内的时间点，剩下的队列内保存的都是允许范围内的时间点，
 * 最后返回队列的长度，即为当前时间点 t 所有允许范围内的 ping 操作次数。
 */

public class Answer {

    Queue<Integer> pings = new LinkedList<>();

    @Test
    public void testPing(){

    }

    int ping(int t){
        pings.add(t);
        while (t-3000 > pings.peek()){
            pings.poll();
        }
        return pings.size();
    }
}
