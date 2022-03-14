package org.demon.datasource.config.dds;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by Qu Jin
 * Date 2022/3/11 15:54
 */
@Slf4j
public class DataSourceUtil {

    /**
     * 切换数据源
     * @param dataSourceStr
     */
    public static void switchDataSource(String dataSourceStr){
        if(!DynamicDataSourceContextHolder.containDataSourceKey(dataSourceStr)){
            log.error("Datasource {} is not exist!", dataSourceStr);
        }else{
            DynamicDataSourceContextHolder.setDataSourceKey(dataSourceStr);
            log.info("Datasource switch to {}.", dataSourceStr);
        }
    }

    /**
     * 重置数据源
     */
    public static void restoreDataSource(){
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore Datasource to default.");
    }
}
