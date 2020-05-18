package 基础.反射;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program springbootcachedemo
 * @description: 反射联系
 * @author: xielinzhi
 * @create: 2019/05/11 21:34
 */

/*
2. 利用反射和重载完成以下功能
1)创建Student类，类中有属性name和age并封装属性
2)重载Student的构造函数，一个是无参构造并，另一个是带两个参数的有参构造，要求在构造函数打印提示信息
3)创建带main函数的NewInstanceTest类，利用Class类得到Student对象
4)通过上述获取的Class对象分别调用Student有参函数和无参函数

 */

class  Student{
    private String name;
    private String age;

    public Student() {
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        Class clazz = Student.class;
        Student student = (Student) clazz.newInstance();
        System.out.println(student.toString());
        Constructor constructor = clazz.getConstructor(String.class,String.class);
        Student student1 = (Student)constructor.newInstance("xlz","123");
        System.out.println(student1.toString());


    }
}
