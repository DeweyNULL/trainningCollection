package 算法题;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author: xielinzhi
 * @create: 2019/05/08 15:25
 */

public class TypeArray {
    public int[] multiply(int[] A) {
        int b[] = new int[A.length];
        for(int i = 0 ; i <A.length ; i++){
            int temp = 0;
            boolean isFirst = true;
            for(int j = 0 ; j<A.length ; j++){
                if(j==i) continue;
                if(isFirst){
                    temp = A[j];
                    isFirst = false;
                }else{
                    temp*=A[j];
                }
            }
            b[i] = temp;
        }

        return b;
    }

    @Test
    public void test(){
        int a[] = { 1,2,3,4,5};
        multiply(a);
    }
}
