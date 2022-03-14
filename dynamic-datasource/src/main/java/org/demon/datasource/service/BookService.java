package org.demon.datasource.service;

import org.demon.datasource.entity.Book;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/14 15:53
 */
public interface BookService {

    /**
     * 指定数据源获取书目列表
     * @param dataSourceKey
     * @return
     */
    List<Book> getBookList(String dataSourceKey);

    /**
     * 注解方式指定数据源
     * @return
     */
    List<Book> getBookList();
}
