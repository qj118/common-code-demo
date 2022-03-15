package org.demon.pagehelper.service;

import org.demon.pagehelper.utils.PageResult;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:10
 */
public interface BookService {

    PageResult getBookList(int pageNum, int pageSize);
}
