package 设计模式.创建型.抽象工厂模式;

/**
 * @program testCollections
 * @description: 抽象工厂模式
 *          根据工厂方法，把产品再进行一次抽象
 *          工厂方法对比下就发现，多了一个产品系列叫Product1，工厂接口里多了一个方法，叫getProduct1，所以抽象工厂模式就是工厂方法模式添加了抽象产品所演变而来
 * @author: xielinzhi
 * @create: 2020/04/28 11:34
 */



//抽象产品
interface Product{}

//具体产品
class ProductA implements Product{}
class ProductB implements Product{}

//工厂接口
interface Factory{
    Product getProduct();
}

//具体的工厂A，创造产品A
class FactoryA implements Factory{

    public Product getProduct() {
        return new ProductA();
    }

}
//具体的工厂B，创造产品B
class FactoryB implements Factory{

    public Product getProduct() {
        return new ProductB();
    }

}

/*   假设以上是一个第三方jar包中的工厂方法模式，我们无法改动源码   */

//我们自己特有的产品
interface MyProduct{}

//我们自己特有的产品实现
class MyProductA implements MyProduct{}
class MyProductB implements MyProduct{}

//我们自己的工厂接口
interface MyFactory{
    MyProduct getMyProduct();
}

//我们自己特有的工厂A，产生产品A
class MyFactoryA implements MyFactory{

    public MyProduct getMyProduct() {
        return new MyProductA();
    }

}

//我们自己特有的工厂B，产生产品B
class MyFactoryB implements MyFactory{

    public MyProduct getMyProduct() {
        return new MyProductB();
    }

}

/*  到这里是我们自己的一套工厂方法模式，去创造我们自己的产品，以下我们将以上二者组合   */

//我们使用组合的方式将我们的产品系列和jar包中的产品组合起来
class AssortedFactory implements MyFactory,Factory{

    MyFactory myFactory;
    Factory factory;

    public AssortedFactory(MyFactory myFactory, Factory factory) {
        super();
        this.myFactory = myFactory;
        this.factory = factory;
    }

    public Product getProduct() {
        return factory.getProduct();
    }

    public MyProduct getMyProduct() {
        return myFactory.getMyProduct();
    }

}


public class AbstractFactory {
}