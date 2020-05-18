package 基础.输入输出;

import org.junit.Test;

import java.io.*;

/**
 * @program springbootcachedemo
 * @description: 文件复制
 * @author: xielinzhi
 * @create: 2019/05/11 17:15
 */

public class Copy {
    @Test
    public void testcopy() throws Exception{

        FileInputStream fileInputStream = new FileInputStream("test");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("test"));

        //BufferedReader bufferedReader = new BufferedReader(fileInputStream);

        FileReader fileReader = new FileReader("");
        //fileReader.read

    }

    @Test
    public void testsystemin()throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = new String("asdb");

        System.out.println(temp.toUpperCase());
    }

    @Test
    public void testRead() throws Exception{

    }
}
