package 设计模式.结构型.代理模式;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/**
 * @program testCollections
 * @description: 静态代理
 * @author: xielinzhi
 * @create: 2019/11/26 20:20
 */

interface Connection  extends Wrapper {

    Statement createStatement() throws SQLException;

    void close() throws SQLException;

}
public class ConnectionProxy implements Connection{

    private Connection connection;

    public ConnectionProxy(Connection connection) {
        super();
        this.connection = connection;
    }

    public ConnectionProxy(java.sql.Connection remove) {

    }

    public Statement createStatement() throws SQLException{
        return connection.createStatement();
    }

    public void close() throws SQLException{
        System.out.println("不真正关闭连接，归还给连接池");
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
 class StaticProxy {
}
