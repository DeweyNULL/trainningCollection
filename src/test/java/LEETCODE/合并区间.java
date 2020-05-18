package LEETCODE;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program testCollections
 * @description: 合并区间
 * @author: xielinzhi
 * @create: 2020/04/02 19:31
 */

public class 合并区间 {

    int[][] merge(int[][] intervals){
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        //排序 小-》大
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                } else if(o1[0]< o2[0]){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        //合并
        int[][] consequece = new int[intervals.length][];
        int index = 0;
        for (int i = 1; i < intervals.length ; i++) {
            //当前与上一个判断
            int[] last = intervals[i-1];
            int[] now = intervals[i];
            if(last[1]<now[0]){
                //上一个的末尾小于现在的开头，放入结果
                consequece[index++] = last;
            }else if(last[1]<=now[1]){
                //上一个的末尾小于等于现在的末尾，合并现在的开头，用于下一次比较
                intervals[i][0] = last[0];
            }
            if(i == intervals.length-1){
                consequece[index++] =  intervals[i];
            }
        }
        return consequece;
    }

    @Test
    public  void testArr() {
        int[][] intervals = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] merge = merge(intervals);
        int[][] intervals1 = {{1, 4}, {4, 5}};
        int[][] merge1 = merge(intervals1);
        System.out.println(1);
    }
}
