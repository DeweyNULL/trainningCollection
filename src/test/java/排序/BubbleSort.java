package 排序;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 冒泡排序
 * @author: xielinzhi
 * @create: 2019/05/03 12:19
 */

public class BubbleSort {
    public void bubbleSort(int a[]){
        if(null == a || a.length<2) return;

        boolean flag = true;

        for (int i = 0 ; i<a.length-1;i++){
            flag = true;
            for(int j = 0 ; j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    @Test
    public void example(){
        int a[] = {2,1,3,4,55,7,8,2,1,0};
        bubbleSort(a);

        for (int temp:a
        ) {
            System.out.print(temp+",");
        }
    }
}
