package org.demon.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Create by Qu Jin
 * Date 2022/3/14 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String bookName;
    private String bookAuthor;
    private BigDecimal price;
}
