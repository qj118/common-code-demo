## 注意事项

1. 禁用数据源自动配置
2. 重写数据源配置（@configuration）
   1. @ConfigurationProperties 指定数据源配置项；
   2. 自定义动态数据源类以及数据源上下文；
   3. 配置文件中配置的 mybatis 失效，需要在配置类中返回 SqlSessionFactory 对象，在方法中完成 mybatis 的相应配置。
3. 代码中实现了数据源切换的工具类，以及切片实现注解切换。
4. swagger 2.9.2 与 springboot 2.6.x 不兼容，需要切换回 2.5.x