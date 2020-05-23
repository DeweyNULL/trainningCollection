package 设计模式.创建型.单例模式;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/28 10:45
 */

class BetterSingleton {

    private BetterSingleton(){}

    public static BetterSingleton getInstance(){
        return SingletonInstance.instance;
    }

    private static class SingletonInstance{
        static BetterSingleton instance = new BetterSingleton();
    }
}

public class Single {

    private static Single single;

    public static Single getInstance(){

        if(single == null){
            synchronized (Single.class){
                if(single == null)
                    single = new Single();
            }
        }
        return single;
    }
}


