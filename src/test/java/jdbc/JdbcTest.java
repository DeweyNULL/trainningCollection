package jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class JdbcTest {

    private static final String URL = "jdbc:oracle:thin:@10.100.1.20:1521:db3";
    private static final String USER = "aml_general_110";
    private static final String PASSWORD = "bangsun";

    @Test
    public void exec() throws Exception {


        Properties info = new Properties();
        info.put ("user", USER);
        info.put ("password", PASSWORD);
        Connection connection = DriverManager.getConnection(URL, info);

        String sql = "UPDATE RISK_CUSTOMER set UPDATE_TIME = add_months(UPDATE_TIME,+204) \n" +
                "WHERE UPDATE_TIME >= to_date( '2003-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS' ) \n" +
                "\tAND UPDATE_TIME <= to_date( '2003-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS' )";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long startTimeStamp = System.currentTimeMillis();
         preparedStatement.executeQuery();

         System.out.println((System.currentTimeMillis() - startTimeStamp));



//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        ResultSetMetaData rsmd = resultSet.getMetaData();
//        int count = rsmd.getColumnCount();
//
//        while(resultSet.next()){
//            for(int i=0;i<count;i++){
////                log.info(String.valueOf(resultSet.getObject(i + 1)));
//                log.info(rsmd.getTableName(i + 1));
//            }
//        }



//        String sql = "BEGIN update COMMON_DAO set name = ? where id = ?;update COMMON_DAO set name = ? where id = ?; END;";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setObject(1, "suzy111");
//        preparedStatement.setObject(2, 1);
//        preparedStatement.setObject(3, "suzy211");
//        preparedStatement.setObject(4, 211);
//
//        preparedStatement.executeUpdate();
    }
}
