package org.demon.export.excel.service.impl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.demon.export.excel.entity.Book;
import org.demon.export.excel.mapper.BookMapper;
import org.demon.export.excel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/10 16:35
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    private static final String TITLE = "书目价格单";
    private static final String[] BOOK_HEADERS = {"编码", "书名", "作者", "价格"};

    @Override
    public Workbook exportBooks(int type) {
        Workbook workbook;
        if(type == 0) {
            workbook = new HSSFWorkbook();
        }else{
            workbook = new XSSFWorkbook();
        }
        try {
            Sheet sheet = workbook.createSheet(TITLE);
            int rowNum = 1;
            Row row = sheet.createRow(0);
            for (int i = 0; i < BOOK_HEADERS.length; i ++){
                Cell cell = row.createCell(i);
                cell.setCellValue(BOOK_HEADERS[i]);
            }
            List<Book> books = bookMapper.selectAll();
            if(!CollectionUtils.isEmpty(books)){
                for (Book book : books) {
                    if(book != null){
                        row = sheet.createRow(rowNum);
                        row.createCell(0).setCellValue(book.getId());
                        row.createCell(1).setCellValue(book.getBookName());
                        row.createCell(2).setCellValue(book.getBookAuthor());
                        row.createCell(3).setCellValue(book.getPrice());
                        rowNum ++;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("book_export_error");
        }
        return workbook;
    }
}
