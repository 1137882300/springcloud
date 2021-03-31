package com.zhong.springcloud.controller;

import com.zhong.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by cc on 2021/3/29
 */
@RestController
public class DeptConsumerController {

    // 理解：消费者，不应该有service层
    // RestTemplate  供我们直接调用就可以了，需要注册到spring中
    // ( url, 实体：Map , Class<T> responseType)

    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程 http 服务的方法，简单的restful 服务模板
//   ribbon 这里的地址应该是变量，通过服务名来访问
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";//通过微服务名称去访问的



    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //被调用的是get的请求，所以这里是用get开始的
        return restTemplate.getForObject(REST_URL_PREFIX+ "/dept/get/"+id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+ "/dept/list",List.class);
    }





}
