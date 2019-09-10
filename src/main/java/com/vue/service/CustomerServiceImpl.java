package com.vue.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vue.dao.CustomerDao;
import com.vue.entity.Customer;
import com.vue.util.JsonUtil;
import com.vue.util.Page;
import com.vue.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:com.vue.service
 * @Date:2019/9/3 17:05
 * @Author: zsy
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
//    JsonUtil jsonUtil;


    @Override
    public int count() {
        return customerDao.count();
    }

    public Map<String, String> iterCustomer(Customer customer) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("id", customer.getId().toString());
        resultMap.put("name", customer.getName());
        resultMap.put("phone", customer.getPhone());
        resultMap.put("email", customer.getEmail());
        resultMap.put("education", customer.getEducation());
        resultMap.put("graduationschool", customer.getGraduationschool());
        resultMap.put("profession", customer.getProfession());
        resultMap.put("profile", customer.getProfile());
        return resultMap;
    }

    @Override
    public String findAllPageMap(Map<String, Integer> pageMap) {
        return JsonUtil.toJSON(customerDao.findAllPageMap(pageMap));
    }

    @Override
    public String findAllPageClass(Page page) {
        return JsonUtil.toJSON(customerDao.findAllPageClass(page));
    }

    @Override
    public String findAllPageSql(Integer pageNo, Integer pageSize) {
        return JsonUtil.toJSON(customerDao.findAllPageSql(pageNo, pageSize));
    }

    @Override
    public String findAllPage(Integer pageNo, Integer pageSize) {
        List<Customer> customers = customerDao.findAll();
        List<Map<String, String>> resultList = new ArrayList<>();
        PageUtil<Customer> pageUtil = new PageUtil<>();
        for (Customer customer : pageUtil.pageList(customers, pageNo, pageSize)) {
            resultList.add(iterCustomer(customer));
        }
        return JsonUtil.toJSON(resultList);
    }

    @Override
    public String findAll() {
        List<Customer> customers = customerDao.findAll();
        List<Map<String, String>> resultList = new ArrayList<>();

        for (Customer customer : customers) {
            resultList.add(iterCustomer(customer));
        }
        /**
         * 将JsonUtil 中的toJSON方法生命为静态方法
         * 不需要实例化即可调用
         */
        return JsonUtil.toJSON(resultList);
    }

    @Override
    public String findById(Integer id) {
        return JsonUtil.toJSON(customerDao.findById(id));
    }

    @Override
    public Integer insertOne(Customer customer) {
        return customerDao.insertOne(customer);
    }

    @Override
    public Integer delete(Integer id) {
        return customerDao.delete(id);
    }

    @Override
    public Integer update(Customer customer) {
        return customerDao.update(customer);
    }
}
