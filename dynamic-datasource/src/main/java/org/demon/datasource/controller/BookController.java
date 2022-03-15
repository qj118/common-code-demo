package org.demon.datasource.controller;

import io.swagger.annotations.ApiOperation;
import org.demon.datasource.config.dds.DataSource;
import org.demon.datasource.entity.Book;
import org.demon.datasource.service.BookService;
import org.demon.datasource.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/14 16:01
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("获取图书列表")
    @GetMapping("/books")
    @DataSource("slave")
    public CommonResult getBookList(){
        List<Book> bookList = bookService.getBookList();
        return new CommonResult(bookList);
    }
}
