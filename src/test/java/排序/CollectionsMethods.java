package 排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program springbootcachedemo
 * @description: 测试collections的工具集
 * @author: xielinzhi
 * @create: 2019/05/08 15:42
 */

public class CollectionsMethods {

    @Test
    public void testSort(){


        Integer a[] = {11,22,123,213,101,555};

        Collections.sort(Arrays.asList(a));

        System.out.println(a);



    }
}
