package org.demon.excel2entity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:41
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
