package org.demon.export.excel.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.demon.export.excel.service.BookService;
import org.demon.export.excel.utils.CommonResult;
import org.demon.export.excel.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Create by Qu Jin
 * Date 2022/3/11 9:21
 */
@RestController
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/export/books")
    public CommonResult exportBooks(HttpServletResponse response){
        CommonResult result;
        try {
            Workbook workbook = bookService.exportBooks(0);
            ResponseUtil.writeToResponse(response, workbook, "Books.xls");
            result = CommonResult.ok("export_books_success");
        } catch (Exception e) {
            log.error(e.getMessage());
            result = CommonResult.error(e.getMessage());
        }
        return result;
    }

    @GetMapping("/export/booksX")
    public CommonResult exportBooksX(HttpServletResponse response){
        CommonResult result;
        try {
            Workbook workbook = bookService.exportBooks(1);
            ResponseUtil.writeToResponse(response, workbook, "Books.xlsx");
            result = CommonResult.ok("export_books_success");
        } catch (Exception e) {
            log.error(e.getMessage());
            result = CommonResult.error(e.getMessage());
        }
        return result;
    }
}
