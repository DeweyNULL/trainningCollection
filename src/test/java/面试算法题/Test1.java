package 面试算法题;

/**
 * @program testCollections
 * @description:
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * @author: xielinzhi
 * @create: 2020/05/18 19:27
 */

public class Test1 {

    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length < 1) return  null;

        int [] consequence = new int[A.length];

        int single = 1 ;
        int doubleNumber = 0;

        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            if(temp % 2 == 0){
                consequence[doubleNumber] = temp;
                doubleNumber+=2;
            }else {
                consequence[single] = temp;
                single+=2;
            }
        }

        return consequence;
    }
}
