package 设计模式.结构型.装饰器模式;

/**
 * @program testCollections
 * @description:
 *                  1，不改变原类文件。
 *                  2，不使用继承。
 *                  3，动态扩展。
 * @author: xielinzhi
 * @create: 2020/04/29 13:55
 */

//具体的装饰器
public class Decorator  extends DecoratorAll{
    Decorator(OriginalClass originalClass) {
        super(originalClass);
    }

    @Override
    public void method() {
        super.method();
    }

    //具体的自己的方法
    public void methodA(){
        System.out.println("自己的方法");
    }
}

// 装饰器模式
class DecoratorAll extends OriginalClass{

    OriginalClass originalClass ;

    DecoratorAll(OriginalClass originalClass){
        super();
        this.originalClass = originalClass;
    }

    @Override
    public void method() {
        originalClass.method();
    }
}
// 原始接口
interface Original{
    public void method();
}

//原始实现方式
class OriginalClass implements Original{

    @Override
    public void method() {
        System.out.println("原来的方法");
    }
}