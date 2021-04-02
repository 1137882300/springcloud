package com.zhong.springcloud;

import com.zhong.myrule.ZhongRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by cc on 2021/3/29
 */
@SpringBootApplication
@EnableEurekaClient  //configuration 是自己指定的类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT" ,configuration = ZhongRule.class)//在微服务启动的时候就能去加载自定义的Ribbon类
public class DeptConsumer_80 {

//    Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关系IP地址和端口号

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
