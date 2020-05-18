import org.junit.Test;

/**
 * @program testCollections
 * @description: 排序
 * @author: xielinzhi
 * @create: 2020/04/24 19:19
 */

public class Sort {

    //归并排序
    public void merge(int nums[], int left , int right){
        if(left>=right) return;
        int mid = left + (right-left) / 2;
        merge(nums,left,mid);
        merge(nums,mid+1,right);
        //合并
        addAll(nums,left,mid,right);
    }
    public void addAll(int[] nums,int left , int mid , int right){
        int i = left;
        int j = mid + 1;
        int k = 0;
        int [] temp =new int[right - left + 1];
        while(i <= mid  && j<=right ){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            nums[left+l] = temp[l];
        }
    }

    @Test
    public void testArr(){
        int [] arr = {3,2,1,5,2,6};
        merge(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
