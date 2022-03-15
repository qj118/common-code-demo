package org.demon.pagehelper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.demon.pagehelper.mapper.BookMapper;
import org.demon.pagehelper.service.BookService;
import org.demon.pagehelper.utils.PageResult;
import org.demon.pagehelper.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:22
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageResult getBookList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return PageUtil.getPageResult(new PageInfo(bookMapper.selectAll()));
    }
}
