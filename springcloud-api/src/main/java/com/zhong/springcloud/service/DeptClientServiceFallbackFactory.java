package com.zhong.springcloud.service;

import com.zhong.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
// 降级 (是熔断的一种策略)
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {


        return new DeptClientService() {
            @Override
            public boolean saveDept(Dept dept) {
                return false;
            }

            @Override
            public Dept getById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDb_source("no data");
            }

            @Override
            public List<Dept> listAll() {
                return null;
            }
        };
    }
}
