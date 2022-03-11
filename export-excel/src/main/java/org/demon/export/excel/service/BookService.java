package org.demon.export.excel.service;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Create by Qu Jin
 * Date 2022/3/10 16:00
 */
public interface BookService {

    /**
     * @param type 导出文件格式
     *     0 xls
     *     1 xlsx
     * @return
     */
    Workbook exportBooks(int type);
}
