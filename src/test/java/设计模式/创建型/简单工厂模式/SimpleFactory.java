package 设计模式.创建型.简单工厂模式;

/**
 * @program testCollections
 * @description: 简单工厂模式 / 静态工厂方法
 * @author: xielinzhi
 * @create: 2020/04/28 10:53
 */

interface IProduct {
    public void method();
}

class ProductA implements IProduct{

    @Override
    public void method() {
        System.out.println("生产A产品");
    }
}

class ProductB implements IProduct{

    @Override
    public void method() {
        System.out.println("生产B产品");
    }
}

public class SimpleFactory {

    public static IProduct createProduct(String productName){
        if("A".equals(productName)){
            return new ProductA();
        }else if("B".equals(productName)){
            return new ProductB();
        }
        return null;
    }
}
