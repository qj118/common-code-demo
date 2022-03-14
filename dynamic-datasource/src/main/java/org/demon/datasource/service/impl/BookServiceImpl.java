package org.demon.datasource.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.demon.datasource.config.dds.DataSourceUtil;
import org.demon.datasource.entity.Book;
import org.demon.datasource.mapper.BookMapper;
import org.demon.datasource.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/14 15:57
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList(String dataSourceKey) {
        DataSourceUtil.switchDataSource(dataSourceKey);
        List<Book> books = bookMapper.selectAll();
        DataSourceUtil.restoreDataSource();
        return books;
    }

    @Override
    public List<Book> getBookList() {
        return bookMapper.selectAll();
    }
}
