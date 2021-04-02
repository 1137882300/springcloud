package zhong.springcloud.controller;

import com.zhong.springcloud.pojo.Dept;
import com.zhong.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cc on 2021/3/29
 */


@RestController
public class DeptConsumerController {



    @Autowired
    private DeptClientService service = null;


    @RequestMapping("/consumer/dept/save")
    public boolean add(Dept dept){
        return this.service.saveDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return  this.service.getById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return  this.service.listAll();
    }





}
