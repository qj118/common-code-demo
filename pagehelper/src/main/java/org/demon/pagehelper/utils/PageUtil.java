package org.demon.pagehelper.utils;

import com.github.pagehelper.PageInfo;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:16
 */
public class PageUtil {

    public static PageResult getPageResult(PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setNumberOfElements(pageInfo.getSize());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
