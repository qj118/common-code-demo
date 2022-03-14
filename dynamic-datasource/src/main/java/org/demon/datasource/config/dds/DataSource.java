package org.demon.datasource.config.dds;

import java.lang.annotation.*;

/**
 * Create by Qu Jin
 * Date 2022/3/11 16:28
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    /**
     * 数据源 key 值
     * @return
     */
    String value();
}
