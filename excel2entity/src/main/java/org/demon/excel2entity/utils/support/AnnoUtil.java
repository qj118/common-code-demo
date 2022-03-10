package org.demon.excel2entity.utils.support;

import org.demon.excel2entity.utils.annotation.Column;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:35
 */
public class AnnoUtil {

    private AnnoUtil() {}

    /**
     * @param cls
     * @return
     */
    public static final Map<Integer, Field> columnAction(Class<?> cls) {
        Map<Integer, Field> resultMap = new HashMap<>();
        if (cls != null) {
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    Integer index = column.index();
                    resultMap.put(index, field);
                }
            }
        }
        return resultMap;
    }
}
