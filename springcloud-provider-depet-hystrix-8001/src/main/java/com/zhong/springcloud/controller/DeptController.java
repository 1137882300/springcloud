package com.zhong.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhong.springcloud.pojo.Dept;
import com.zhong.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cc on 2021/3/29
 */
//提供 Restful 服务
@RestController
public class DeptController {//http://localhost:8001/dept/list

    @Autowired
    private DeptService deptService;


    @HystrixCommand(fallbackMethod = "hystrixGet")//这个方法失败了就去调用另一个方法
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        Dept dept = deptService.findById(id);
        if (dept == null){
            throw new RuntimeException("id=>"+id+", id为空");
        }
        return dept;
    }


    //备选方案
    public Dept hystrixGet(@PathVariable Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>\"+id+\", id为空,--@hystrix")
                .setDb_source("no this database in mysql");
    }




}
