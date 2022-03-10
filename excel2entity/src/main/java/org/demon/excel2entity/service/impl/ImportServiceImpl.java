package org.demon.excel2entity.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.demon.excel2entity.dto.ImportBookDTO;
import org.demon.excel2entity.entity.Book;
import org.demon.excel2entity.mapper.BookMapper;
import org.demon.excel2entity.service.ImportService;
import org.demon.excel2entity.utils.support.ExcelImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:51
 */
@Slf4j
@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void importBook(MultipartFile file) {
        List<ImportBookDTO> importBookDTOS = ExcelImport.toPojo(file, ImportBookDTO.class, 1);
        log.info("导入书目{}", importBookDTOS);
        for (ImportBookDTO importBookDTO : importBookDTOS) {
            Book book = new Book();
            book.setBookName(importBookDTO.getName());
            book.setBookAuthor(importBookDTO.getAuthor());
            book.setPrice(importBookDTO.getPrice());
            if(bookMapper.insertBook(book) != 1){
                throw new RuntimeException("insert_book_failed");
            }
        }
    }
}
