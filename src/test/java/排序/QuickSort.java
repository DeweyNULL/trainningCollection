package 排序;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 快速排序
 * @author: xielinzhi
 * @create: 2019/05/03 13:46
 */

public class QuickSort {

    public void quickSort(int[] a, int low, int high) {

        if(null == a || a.length<1){
            return;
        }
        if(low >= high) return;

        int mid = partition(a,low,high);
        quickSort(a,low,mid-1);
        quickSort(a,mid+1,high);
    }

    private int partition(int[] a, int low, int high) {
        int partition = a[low];
        while (low<high){
            while(low<high && partition <= a[high]){
                high--;
            }
            a[low] = a[high];

            while (low < high && a[low]<= partition){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = partition;
        return low;
    }

    @Test
    public void testShellSort(){
        int a[] = {2,1,3,4,55,7,8,2,1,0};
        quickSort(a,0,a.length-1);

        for (int temp:a
        ) {
            System.out.print(temp+",");
        }
    }
}
