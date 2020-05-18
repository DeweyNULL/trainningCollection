package 基础.输入输出;

/**
 * @program springbootcachedemo
 * @description: io测试
 * @author: xielinzhi
 * @create: 2019/05/05 18:22
 */

public class TestIO {

    public TestIO() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        TestIO.Inner s3 = new TestIO.Inner();
        System.out.println(s3.a);
    }

    class Inner {
        public int a = 5;
    }

    public static void main(String[] args) {
        TestIO t = new TestIO();
        Inner r = t.new Inner();
        System.out.println(r.a);
    }
}


