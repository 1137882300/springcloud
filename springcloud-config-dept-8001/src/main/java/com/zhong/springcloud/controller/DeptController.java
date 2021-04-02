package com.zhong.springcloud.controller;

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

    //获取一些配置的信息，得到具体的微服务
    @Resource
    private DiscoveryClient client;


    @PostMapping("/dept/add")
    public boolean saveDept(Dept dept){
       return deptService.saveDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        if (dept == null){
            throw new RuntimeException("fail");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> listDept(){
        return deptService.listDept();
    }


    //注册进来的微服务 ，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println(services);

        //得到一个具体的微服务信息,通过具体的微服务 id，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        instances.forEach((instance)->{
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
            );
        });
        return this.client;
    }



}
