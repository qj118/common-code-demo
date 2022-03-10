package org.demon.excel2entity.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    /**
     * 所在的列
     *
     * @return
     */
    int index();

    /**
     * 字段类型
     *
     * @return
     */
    Class<?> type() default String.class;
}
