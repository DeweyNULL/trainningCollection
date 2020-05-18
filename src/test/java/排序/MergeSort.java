package 排序;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 归并排序
 * @author: xielinzhi
 * @create: 2019/05/03 13:07
 */

public class MergeSort {

    public void mergeSort(int a[] , int low , int high){
        int mid = (low+high)/2;

        if(low >= high) return;

        mergeSort(a,low,mid); //排序左边

        mergeSort(a,mid+1,high); //排序右边

        merge(a,low,mid,high); //合并

    }

    // 合并
    private void merge(int a[], int low, int mid, int high) {
         int i = low;
         int j = mid+1;
         int temp[] = new int[high-low+1];
         int k = 0;

         while(i<=mid && j<=high){
             if(a[i]>a[j]){
                 temp[k++] = a[j++];
             }else {
                 temp[k++] = a[i++];
             }
         }

         while(i<=mid){
             temp[k++] = a[i++];
         }

         while(j<=high){
            temp[k++] = a[j++];
         }

         for(int t = 0 ; t<temp.length;t++){
             a[low+t] = temp[t];
         }
    }

    @Test
    public void testShellSort(){
        int a[] = {2,1,3,4,55,7,8,2,1,0};
        mergeSort(a,0,a.length-1);

        for (int temp:a
        ) {
            System.out.print(temp+",");
        }
    }
}
