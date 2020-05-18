package 排序;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 选择排序
 * @author: xielinzhi
 * @create: 2019/05/03 12:32
 */

public class SelectSort {
    public void selectSort(int a[]){
        if(null == a || a.length < 2) return;

        for(int i = 0 ; i<a.length ; i++){
            for(int j = i+1 ; j<a.length ; j++ ){
                if(a[i]>a[j]){
                  int temp = a[i];
                  a[i] = a[j];
                  a[j] = temp;
                }
            }
        }
    }

    @Test
    public void example(){
        int a[] = {2,1,3,4,55,7,8,2,1,0};
        selectSort(a);

        for (int temp:a
        ) {
            System.out.print(temp+",");
        }
    }
}
