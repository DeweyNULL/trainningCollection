package 算法题;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: xielinzhi
 * @create: 2019/05/09 10:05
 */

public class FindNumber {

    public boolean Find(int target, int [][] array) {
        boolean hasNumber = false;
        int len = array.length;
        int col = array[0].length;
        for(int i = 0 ; i < len ; i++){
            if(target<array[i][0]) break;
            for(int j = 0 ; j < col ; j++){
                if(array[i][j] == target){
                    hasNumber = true;
                    break;
                }

            }
            break;
        }

        return hasNumber;
    }

    @Test
    public void testFind(){
        int array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 7;

        Find(target,array);
    }
}
