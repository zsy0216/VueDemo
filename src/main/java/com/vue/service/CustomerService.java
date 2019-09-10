package com.vue.service;

import com.vue.entity.Customer;
import com.vue.util.Page;

import java.util.List;
import java.util.Map;

/**
 * @PackageName:com.vue.service
 * @Date:2019/9/3 17:03
 * @Author: zsy
 */
public interface CustomerService {
//    List<Customer> findAll();

    String findAll();

    String findById(Integer id);

    Integer insertOne(Customer customer);

    Integer delete(Integer id);

    Integer update(Customer customer);

    //查询所有之后再分页
    String findAllPage(Integer pageNo, Integer pageSize);

    //使用sql分页
    String findAllPageSql(Integer pageNo, Integer pageSize);

    //包装对象传递参数
    String findAllPageClass(Page page);

    //封装Map集合传递参数
    String findAllPageMap(Map<String, Integer> pageMap);

    int count();
}
