package org.demon.excel2entity.utils.enter;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:39
 */
@Slf4j
public class CellResolve {

    private static final String ERROR_CELL_FORMAT = "cell format error: {}";
    private CellResolve() {}


    /**
     * 对于Excel而言,如果该单元格是空，则Cell=null
     * 当获取单元格的内容抛异常时，则表示excel内部数据异常,该框架的处理方式是直接赋为null
     * @param clazz
     * @param <T>
     * @return
     */
    public static final <T> T getValueFor(Cell cell, Class<T> clazz) {
        if (clazz == Date.class) {
            try {
                return clazz.cast(cell.getDateCellValue());
            } catch (Exception e) {
                //捕获的异常可能有两种,一: excel单元格为空，抛空指针异常; 二: 单元格内容格式出错
                log.error(ERROR_CELL_FORMAT, e.getMessage());
            }
        }

        if (clazz == String.class) {
            try {
                cell.setCellType(CellType.STRING);
                return clazz.cast(cell.getStringCellValue());
            } catch (Exception e) {
                log.error(ERROR_CELL_FORMAT, e.getMessage());
            }
        }

        if (clazz == Long.class) {
            try {
                return clazz.cast(((Double) cell.getNumericCellValue()).longValue());
            } catch (Exception e) {
                log.error(ERROR_CELL_FORMAT, e.getMessage());
            }
        }

        if (clazz == Integer.class) {
            try {
                return clazz.cast(((Double) cell.getNumericCellValue()).intValue());
            } catch (Exception e) {
                log.error(ERROR_CELL_FORMAT, e.getMessage());
            }
        }
        if(clazz == BigDecimal.class) {
            try{
                return clazz.cast(BigDecimal.valueOf(cell.getNumericCellValue()));
            }catch (Exception e) {
                log.error(ERROR_CELL_FORMAT,e.getMessage());
            }
        }
        return null;
    }
}
