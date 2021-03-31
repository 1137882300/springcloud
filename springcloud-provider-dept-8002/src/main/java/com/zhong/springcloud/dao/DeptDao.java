package com.zhong.springcloud.dao;

import com.zhong.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cc on 2021/3/29
 */
@Mapper
@Repository
public interface DeptDao {

    boolean saveDept(Dept dept);

    Dept findById(Long id);

    List<Dept> listDept();

}
