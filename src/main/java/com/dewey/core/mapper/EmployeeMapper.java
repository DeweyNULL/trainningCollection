package com.dewey.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dewey.core.bean.Employee;

import java.util.List;

/**
 * @program springbootcachedemo
 * @description: employeeMapper
 * @author: xielinzhi
 * @create: 2019/04/24 11:50
 */

//@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    //@Select("select * from Employee")
    public List<Employee> getEmployee();

   //@Select("select * from Employee where id = #{id}")
   //public Employee getbyId(int id);

   //@Update("update Employee set lastName = #{lastName},email = #{email},gender = #{gender} , dId = #{dId} where id = #{id}")
   //public void setbyId(Employee employee);

   //@Insert("Insert into Employee(lastName,email,gender,dId) values(#{lastName},#{email},#{gender},#{dId})")
   //public void insert(Employee employee);

   //@Delete("Delete from Employee where id = #{id}")
   //public void delete(int id);


}
