package com.vue.util;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @PackageName:com.vue.util
 * @Date:2019/9/10 7:53
 * @Author: zsy
 */
public class Page {
    private Integer pageNo;
    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
