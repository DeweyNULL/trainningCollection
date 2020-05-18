package 排序;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 希尔排序
 * @author: xielinzhi
 * @create: 2019/05/02 20:41
 */

public class ShellSort {

    public void shellSort(int a[]){
        if(null == a || a.length<2) return;

        for (int d = a.length / 2 ; d > 0 ; d=d/2){
            for(int i = d ; i < a.length ; i++){
                int temp = a[i];
                int j = i - d ;
                while(j >= 0 && temp < a[j]){
                    a[j+d] = a[j];
                    j=j-d;
                }
                a[j+d] = temp;
            }
        }
    }

    @Test
    public void testShellSort(){
        int a[] = {2,1,3,4,55,7,8,2,1,0};
        shellSort(a);

        for (int temp:a
        ) {
            System.out.print(temp+",");
        }
    }
}
