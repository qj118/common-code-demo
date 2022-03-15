package org.demon.pagehelper.controller;

import io.swagger.annotations.ApiOperation;
import org.demon.pagehelper.service.BookService;
import org.demon.pagehelper.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:33
 */
@RestController("book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * page 从 1 开始
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation("获取书目分页列表")
    public PageResult getBookList(@RequestParam("page") int page, @RequestParam("size") int size){
        return bookService.getBookList(page, size);
    }
}
