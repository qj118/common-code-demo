package org.demon.excel2entity.utils.enter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.demon.excel2entity.utils.support.AnnoUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:34
 */
public class SheetResolve {

    private SheetResolve() {}

    /**
     * sheet解析成List对象,每行一个对象
     *
     * @param start
     * @param end
     * @return
     */
    public static final <T> List<T> sheetHandle(Sheet sheet, int start, int end, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> results = new ArrayList<>();
        Map<Integer, Field> metaInfo = AnnoUtil.columnAction(clazz);
        for (int i = start; i <= end; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                T pojo = RowResolve.toPojo(row, metaInfo, clazz);
                results.add(pojo);
            }
        }
        return results;
    }
}
