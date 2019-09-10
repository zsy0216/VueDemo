package com.vue.dao;

/**
 * @PackageName:com.vue.dao
 * @Date:2019/9/3 15:52
 * @Author: zsy
 */

import com.vue.entity.Customer;
import com.vue.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

/**
 * vue 前端需要的数据：
 * 1.获取所有数据列表；
 * 2.根据名字模糊查询；
 * 3.增加一条数据，name phone email不能为空；
 * 4.根据id更新数据；
 * 5.根据id删除数据；
 * 6.根据id查询数据；
 */
public interface CustomerDao {
    /**
     * 1.
     * @return
     */
    List<Customer> findAll();

    Customer findById(Integer id);

    int insertOne(Customer customer);

    int delete(Integer id);

//    List<Customer> findByName(String name);

    int update(Customer customer);

    List<Customer> findAllPageSql(@Param(value = "pageNo") Integer pageNo,@Param(value = "pageSize") Integer pageSize);

    List<Customer> findAllPageClass(Page page);

    List<Customer> findAllPageMap(Map<String, Integer> pageMap);

    int count();
}
