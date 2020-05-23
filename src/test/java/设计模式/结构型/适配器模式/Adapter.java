package 设计模式.结构型.适配器模式;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * @program testCollections
 * @description: 适配器模式
 *  在两个类，基类与被继承的类之间 添加一层适配的类
 *  如 用于观察者模式
 * @author: xielinzhi
 * @create: 2020/04/29 13:48
 */

public class Adapter {
}

 class HashMapObserverAdapter<K, V> extends HashMap<K, V> implements Observer {

    public void update(Observable o, Object arg) {
        //被观察者变化时，清空Map
        super.clear();
    }

}