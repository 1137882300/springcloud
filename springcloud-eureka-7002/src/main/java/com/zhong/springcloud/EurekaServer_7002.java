package com.zhong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by cc on 2021/3/30
 */
@SpringBootApplication
@EnableEurekaServer //服务端的启动类，可以接收别人注册进来
public class EurekaServer_7002 {

    //http://localhost:7002

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class,args);
    }

}
