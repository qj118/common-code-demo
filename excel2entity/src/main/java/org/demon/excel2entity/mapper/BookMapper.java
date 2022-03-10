package org.demon.excel2entity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demon.excel2entity.entity.Book;

/**
 * Create by Qu Jin
 * Date 2022/3/9 15:41
 */
@Mapper
public interface BookMapper {

    int insertBook(Book book);
}
