package com.dewey.core.controller;

import com.dewey.core.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @program springbootcachedemo
 * @description: controller
 * @author: xielinzhi
 * @create: 2019/04/24 12:08
 */

//@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao dao;

//    @GetMapping("/{id}")
//    public Employee getEmployee(@PathVariable("id") int id){
//
//       return dao.getMapperById(id);
//    }

    @PostMapping("/add")
    public void insert(){

    }

}
