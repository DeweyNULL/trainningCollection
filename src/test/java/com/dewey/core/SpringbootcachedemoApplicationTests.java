package com.dewey.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcachedemoApplicationTests {

    @Autowired
    //EmployeeMapper mapper;

//    @Test
//    public void contextLoads() {
//        Employee employee = new Employee();
//        employee.setLastName("x");
//        employee.setEmail("5120776@qwe.com");
//        employee.setGender(1);
//        employee.setdId(123);
//
//        mapper.insert(employee);
//    }

    @Test
    public void getall(){
      //  List<Employee> list = mapper.getEmployee();
      //  System.out.println(list.size());
    }
}
