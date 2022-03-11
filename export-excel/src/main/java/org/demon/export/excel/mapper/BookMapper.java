package org.demon.export.excel.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demon.export.excel.entity.Book;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/10 15:56
 */
@Mapper
public interface BookMapper {

    List<Book> selectAll();
}
