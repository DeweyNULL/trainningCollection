package 基础.输入输出;

import org.junit.Test;

import java.io.File;

/**
 * @program springbootcachedemo
 * @description: 文件测试
 * @author: xielinzhi
 * @create: 2019/05/11 12:08
 */

public class TestFile {

    public static void main(String[] args) {
        File  file = new File("file");
        if(!file.exists()){
            file.mkdir();
        }

        File file2 = new File(file,"dir");

        if(!file2.exists()){
            file.list();
        }
    }

    @Test
    public void testfile(){
        File file = new File("file");
        String[] filelist = file.list();
        for (String temp: filelist
             ) {
            if(temp.endsWith(".jpg")){
                System.out.println(temp);
            }
            File file1 = new File(temp);
            file1.delete();
        }
    }
}
