package 异常;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 异常测试
 * @author: xielinzhi
 * @create: 2019/07/11 16:50
 */

public class ExceptionTest {

    @Test
    public void exceptionTest(){

        try {
           int a = 1;
           a = a / 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("测试");
    }
}
