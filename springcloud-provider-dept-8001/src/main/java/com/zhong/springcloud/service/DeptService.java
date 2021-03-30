package com.zhong.springcloud.service;

import com.zhong.springcloud.pojo.Dept;

import java.util.List;

/**
 * Created by cc on 2021/3/29
 */
public interface DeptService {

    boolean saveDept(Dept dept);

    Dept findById(Long id);

    List<Dept> listDept();

}
