package org.demon.pagehelper.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {

    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;
    private int numberOfElements;
    private List<?> content;
}
