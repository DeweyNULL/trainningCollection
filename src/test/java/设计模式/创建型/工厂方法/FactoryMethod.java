package 设计模式.创建型.工厂方法;

/**
 * @program testCollections
 * @description: 工厂方法模式
 * @author: xielinzhi
 * @create: 2020/04/28 11:05
 */

interface Light{
    public void turnOn();

    public void turnOff();
}

interface Creator{
    public Light createProduct();
}


public class FactoryMethod {

    public static void main(String[] args) {
        Creator a = new LightACreator();
        Light la = a.createProduct();
        la.turnOn();
        la.turnOff();

        Creator b = new LightBCreator();
        Light lb = b.createProduct();
        lb.turnOn();
        lb.turnOff();
    }
}

class LightA implements Light{
    @Override
    public void turnOn() {
        System.out.println("LightA is on");
    }

    @Override
    public void turnOff() {
        System.out.println("LightA is off");
    }
}
class LightB implements Light{
    @Override
    public void turnOn() {
        System.out.println("LightB is on");
    }

    @Override
    public void turnOff() {
        System.out.println("LightB is off");
    }
}

class LightACreator implements Creator{
    @Override
    public Light createProduct() {
        return new LightA();
    }
}

class LightBCreator implements Creator{
    @Override
    public Light createProduct() {
        return new LightB();
    }
}