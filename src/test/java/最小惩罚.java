import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program testCollections
 * @description: 最小惩罚
 * @author: xielinzhi
 * @create: 2020/04/02 22:27
 */

public class 最小惩罚 {

    public int minPath(int n, int[][] edges, int start, int end){
        if(start == end) return 0;
        int max = 100000000;
        LinkedList<Integer> queue = new LinkedList<>();
        //初始化
        int[][] pointLength =new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pointLength[i][j] = max;
            }
            pointLength[i][i] = 0;
        }
        //存入已有的点点之间距离
        for (int i = 0; i < edges.length; i++) {
            pointLength[edges[i][0]][edges[i][1]] = edges[i][2];
            pointLength[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        //d数组为start点到各个点的距离数组
        int[] d = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            //初始化 将顶点相邻的点放入队列
            d[i]=pointLength[start][i];
            if(d[i]<max){
               queue.offer(i);
            }
        }

        while (queue.size()>0){
            int temp = queue.poll();
            for (int i = 1; i <=n ; i++) {
                if(pointLength[temp][i]<max && temp!=i){
                    //判断是否有从顶点到i的距离小于之前
                    if(d[i]< (d[temp]|pointLength[temp][i])){
                        d[i] = d[temp]|pointLength[temp][i];
                        //如果此时i不在队列中，则放入
                        if(!queue.contains(i)){
                            queue.offer(i);
                        }
                    }
                }
            }
        }
        return d[end] == max ? -1 : d[end];
    }

    @Test
    public  void test() {
        int[][] edges =  {{1,2,1},{2,3,3},{1,3,2}};
        int minPath = minPath(3, edges, 1, 3);
        System.out.println(minPath);
    }
}
