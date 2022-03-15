package org.demon.pagehelper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demon.pagehelper.entity.Book;

import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/15 9:05
 */
@Mapper
public interface BookMapper {

    List<Book> selectAll();
}
