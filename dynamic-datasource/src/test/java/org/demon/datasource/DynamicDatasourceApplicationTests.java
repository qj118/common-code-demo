package org.demon.datasource;

import org.demon.datasource.entity.Book;
import org.demon.datasource.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DynamicDatasourceApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        List<Book> books = bookService.getBookList("primary");
        System.out.println(books);
    }

}
