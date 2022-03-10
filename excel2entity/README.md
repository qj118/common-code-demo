## 前端请求

只需要将 body 设置为 form-data，将 Excel 文件作为一个 Value 值传入即可。

## 后端使用

1. 将 Excel 文件中的信息，封装成实体类 XxxDTO，用 @Column 对每个字段进行注解；
2. 拿到 MutilpartFile 对象 file 后，ExcelImport.toPojo(file, XxxDTO.class, startLine)，将整个 Excel 中的每一行作为一个实体对象放入 List 中。
3. 在 Excel 中 startLine 的起始值是 0。