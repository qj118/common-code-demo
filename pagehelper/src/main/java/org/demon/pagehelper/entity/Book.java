package org.demon.pagehelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private String bookName;
    private String bookAuthor;
    private BigDecimal price;
}
