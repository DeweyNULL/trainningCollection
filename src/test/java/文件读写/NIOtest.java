package 文件读写;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

/**
 * @program springbootcachedemo
 * @description: 文件读写类测试
 * @author: xielinzhi
 * @create: 2019/07/08 10:50
 */

public class NIOtest {

    @Test
    public void nioTest(){
        Path path = Paths.get("testDate.txt");
        System.out.println(path.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date dateNow = new Date();
        String startTimeString = null;
        Date startTime = new Date();
        try {
            if (Files.exists(path)) {
                startTimeString = Files.readAllLines(path, Charset.forName("UTF-8")).get(0);
            }else {
                Files.createFile(path);
                Files.write(path, Collections.singletonList(sdf.format(dateNow)), Charset.forName("UTF-8"));
            }
            startTime =  StringUtils.isBlank(startTimeString) ? dateNow : sdf.parse(startTimeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOut(){
        String str = "nio测试输出";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xielinzhi/Downloads/temp/测试.txt");
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(str.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
