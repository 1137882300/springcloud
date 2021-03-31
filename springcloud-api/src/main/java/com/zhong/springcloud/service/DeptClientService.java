package com.zhong.springcloud.service;

import com.zhong.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @PostMapping("/dept/save")
    boolean saveDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept getById(@PathVariable Long id);

    @GetMapping("/dept/list")
    List<Dept> listAll();


}
