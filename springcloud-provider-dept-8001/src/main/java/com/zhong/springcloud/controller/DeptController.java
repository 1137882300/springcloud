package com.zhong.springcloud.controller;

import com.zhong.springcloud.pojo.Dept;
import com.zhong.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cc on 2021/3/29
 */
//提供 Restful 服务
@RestController
public class DeptController {//http://localhost:8001/dept/list

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean saveDept(Dept dept){
       return deptService.saveDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        return deptService.findById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> listDept(){
        return deptService.listDept();
    }



}
