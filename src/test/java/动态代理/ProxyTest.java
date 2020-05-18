package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program springbootcachedemo
 * @description: 动态代理实践
 * @author: xielinzhi
 * @create: 2019/05/07 10:31
 */

interface MyMethod {
    public void sayhello();
}

class MyInstance implements MyMethod{

    @Override
    public void sayhello() {
        System.out.println("hello world");
    }
}

class MyProxy implements InvocationHandler{

    Object obj;

    public Object bind(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(this.obj,args);
        return returnValue;
    }
}

public class ProxyTest {

}
