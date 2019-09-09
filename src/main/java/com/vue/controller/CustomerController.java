package com.vue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vue.entity.Customer;
import com.vue.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @GetMapping("/allSql")
    public String findAllPageSql(@RequestParam(required = true,defaultValue = "1") Integer pageNo,
                              @RequestParam(required = false,defaultValue = "5") Integer pageSize) {
        return customerService.findAllPageSql(pageNo-1,pageSize);
    }

    @ResponseBody
    @GetMapping("/allPage")
    public String findAllPage(@RequestParam(required = true,defaultValue = "1") Integer pageNo,
                              @RequestParam(required = false,defaultValue = "5") Integer pageSize) {
        return customerService.findAllPage(pageNo,pageSize);
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

        response.setHeader("Access-Control-Allow-Origin","*");

        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");

        customer.setId(id);
        return customerService.update(customer);
    }

    /**
     * test options request.
     * @param response
     * @return
     */
    @RequestMapping(value = "/option",method = RequestMethod.OPTIONS)
    public String getOption(HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");

        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");

        return "";
    }
}
