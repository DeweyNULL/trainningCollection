package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @program springbootcachedemo
 * @description: 深度克隆工具类
 * @author: xielinzhi
 * @create: 2019/05/02 09:26
 */

public class MyUtil {
    private MyUtil(){};

    public static <T> T clone(T obj) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(obj);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (T)objectInputStream.readObject();

    }

    String str=new String("hello");
    char[]ch={'a','b'};
    public static void main(String args[]){
        MyUtil ex=new MyUtil();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }
}
