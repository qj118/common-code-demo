package org.demon.datasource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demon.datasource.entity.Book;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/14 15:50
 */
@Mapper
public interface BookMapper {

    List<Book> selectAll();
}
