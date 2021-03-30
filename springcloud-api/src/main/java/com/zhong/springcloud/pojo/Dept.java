package com.zhong.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by cc on 2021/3/29
 */

/*所有的实体类都必须实现序列换，网络传输，  orm类表关系映射  mysql --对应-- dept   */
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable {

    private Long deptno;//主键
    private String dname;
    private String db_source;//存在哪个数据库的字段，一个服务对应一个数据库，同一个信息可能存在不同的数据库

    public Dept(String dname){
        this.dname = dname;
    }

}
