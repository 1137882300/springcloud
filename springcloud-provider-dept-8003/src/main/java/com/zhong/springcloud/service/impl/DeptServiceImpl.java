package com.zhong.springcloud.service.impl;

import com.zhong.springcloud.dao.DeptDao;
import com.zhong.springcloud.pojo.Dept;
import com.zhong.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cc on 2021/3/29
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean saveDept(Dept dept) {
        return deptDao.saveDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> listDept() {
        return deptDao.listDept();
    }
}
