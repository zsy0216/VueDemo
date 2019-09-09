package com.vue.util;

import java.util.List;

/**
 * @PackageName:com.vue.util
 * @Date:2019/9/9 16:52
 * @Author: zsy
 * 封装
 */
public class PageUtil<T> {

    private int beginIndex;
    private int endIndex;

    public List<T> pageList(List<T> list, int pageNo, int pageSize) {
        int size = list.size();

        beginIndex = (pageNo - 1) * pageSize;
        endIndex = pageNo * pageSize > size ? size : pageNo * pageSize;
//        if (endIndex > size) {
//            endIndex = size;
//        }
        List<T> resultList = list.subList(beginIndex, endIndex);
        return resultList;
    }
}
