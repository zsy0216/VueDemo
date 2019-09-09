package com.vue.service;

import com.vue.entity.Customer;

import java.util.List;

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

    String findAllPage(Integer pageNo, Integer pageSize);

    String findAllPageSql(Integer pageNo, Integer pageSize);
}
