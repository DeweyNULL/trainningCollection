package com.dewey.core;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dewey.core.bean.Employee;
import com.dewey.core.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program springbootcachedemo
 * @description: mysql相关的数据操作
 * @author: xielinzhi
 * @create: 2019/05/22 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMysqlDMLTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void queryTest(){
        List<Employee> list = employeeMapper.getEmployee();
        //System.out.println(list.size());
        for (Employee temp: list
             ) {
            System.out.println(temp);
        }
    }

    @Test
    public void insert(){
        Employee employee = new Employee();
        employee.setEmail("123@123.com");
        employee.setGender(0);
        employee.setLastName("xzz");
        // employee.setId(2);
        Integer index = employeeMapper.insert(employee);
    }

    @Test
    public void update(){

    }

    @Test
    public void list(){
        int begin = 0;
        int end = 1;
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(begin,end),
                new EntityWrapper<Employee>());
        new Condition();
    }


    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;
    @Test
    public void testGenerator(){
        GlobalConfig config = new GlobalConfig(); config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("xlz") //作者
                .setOutputDir("/Users/xielinzhi/IdeaProjects/springbootcachedemo/src/main/java/com/example/springbootcachedemo/dao")
//生成路径 首字母是否为I
                .setFileOverride(true)//文件覆盖
                .setServiceName("%sService") //设置生成的service接口名
                .setIdType(IdType.AUTO); //主键策略 ;

        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setDriverName(driverName)
                .setUsername(userName)
                .setPassword(password);

        StrategyConfig stConfig = new StrategyConfig(); stConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(false) //表名 字段名 是否使用下滑
                .setNaming(NamingStrategy.underline_to_camel) // 数据 库表映射到实体的命名策略
                .setInclude("Employee") //生成的表
                .setTablePrefix("test_"); // 表前缀 //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.example.springbootcachedemo.generator")
                .setController("controller") .setEntity("beans") .setService("service");
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config).
                setDataSource(dsConfig) .setStrategy(stConfig) .setPackageInfo(pkConfig);
        ag.execute();
    }
}
