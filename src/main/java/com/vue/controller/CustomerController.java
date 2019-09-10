package com.vue.controller;


import com.vue.entity.Customer;
import com.vue.service.CustomerService;
import com.vue.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * @PackageName:com.vue.controller
 * @Date:2019/9/3 17:43
 * @Author: zsy
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ResponseBody
    @GetMapping("/allMap")
    public String findAllPageMap(@RequestParam(required = true, defaultValue = "1") Integer pageNo,
                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("pageNo", pageNo - 1);
        pageMap.put("pageSize", pageSize);
        return customerService.findAllPageMap(pageMap);
    }

    @ResponseBody
    @GetMapping("/allClass")
    public String findAllPageClass(@RequestParam(required = true, defaultValue = "1") Integer pageNo,
                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page page = new Page();
        page.setPageNo(pageNo - 1);
        page.setPageSize(pageSize);
        return customerService.findAllPageClass(page);
    }

    @ResponseBody
    @GetMapping("/allSql")
    public String findAllPageSql(@RequestParam(required = true, defaultValue = "1") Integer pageNo,
                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        /**
         * pageSize 是每页显示的条数
         * pageNo 是页码，sql分页传递的第一个参数是开始的索引；
         * 计算公式：开始的索引 = （当前的页码 - 1） * 每页显示的条数
         */
        //数据总数
        int count = customerService.count();
        //计算最大页码
        int maxPage =(int) Math.ceil(count/pageSize.doubleValue());
        //当前页码超出最大页码返回最大页码值：
        pageNo = pageNo>maxPage?maxPage:pageNo;
        //分页开始的索引值
        int index = (pageNo - 1) * pageSize > count ? count : (pageNo - 1) * pageSize;
        return customerService.findAllPageSql(index, pageSize);
    }

    @ResponseBody
    @GetMapping("/allPage")
    public String findAllPage(@RequestParam(required = true, defaultValue = "1") Integer pageNo,
                              @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        return customerService.findAllPage(pageNo, pageSize);
    }

    @ResponseBody
    @GetMapping("/all")
    public String findAll() {
        return customerService.findAll();
    }

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/find/{id}")
    public String findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @PostMapping("/insert")
    @ResponseBody
    public Integer insertOne(@RequestBody Customer customer) {
        return customerService.insertOne(customer);
    }

    @ResponseBody
    @PostMapping("/delete/{id}")
    public Integer delete(@PathVariable Integer id) {
        return customerService.delete(id);
    }

    @ResponseBody
//    @PutMapping("/update/{id}")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.OPTIONS)
    public Integer update(@PathVariable Integer id, @RequestBody Customer customer, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");

        customer.setId(id);
        return customerService.update(customer);
    }

    /**
     * test options request.
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/option", method = RequestMethod.OPTIONS)
    public String getOption(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");

        return "";
    }
}
