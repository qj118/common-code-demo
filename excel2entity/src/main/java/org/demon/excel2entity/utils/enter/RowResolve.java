package org.demon.excel2entity.utils.enter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.demon.excel2entity.utils.annotation.Column;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:36
 */
public class RowResolve {
    private RowResolve() {}

    /**
     * 将row转成Bean
     *
     * @return
     */
    public static final <T> T toPojo(Row row, Map<Integer, Field> metaInfo, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T result = clazz.newInstance();
        for (Map.Entry<Integer, Field> entry : metaInfo.entrySet()) {
            Integer index = entry.getKey();
            Field field = entry.getValue();
            /**
             * 当该列未赋任何值时，获取到的是Cell为null
             */
            Cell cell = row.getCell(index);
            Column column = field.getAnnotation(Column.class);
            field.setAccessible(true);
            Object value = CellResolve.getValueFor(cell, column.type());
            field.set(result,value);
        }
        return result;
    }
}
