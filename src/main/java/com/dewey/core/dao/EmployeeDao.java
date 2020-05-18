package com.dewey.core.dao;

import com.dewey.core.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program springbootcachedemo
 * @description: employeeDao
 * @author: xielinzhi
 * @create: 2019/04/24 11:57
 */

//@Component
public class EmployeeDao {

    @Autowired
    EmployeeMapper mapper;

    Logger logger = LoggerFactory.getLogger(getClass());

//    @Cacheable(cacheNames = "emp")
//    public Employee getMapperById(int id) {
//        logger.info("员工id："+id);
//        return mapper.getbyId(id);
//    }
}
