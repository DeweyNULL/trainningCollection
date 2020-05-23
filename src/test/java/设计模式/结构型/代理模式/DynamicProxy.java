package 设计模式.结构型.代理模式;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program testCollections
 * @description: 动态代理
 * @author: xielinzhi
 * @create: 2019/11/26 20:21
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;




class proxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
public class DynamicProxy {
}
