package org.demon.excel2entity.utils.support;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.demon.excel2entity.utils.enter.SheetResolve;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:24
 */
@Slf4j
public class ExcelImport {

    private ExcelImport() {
    }

    public static final <T> List<T> toPojo(MultipartFile file, Class<T> clazz, int start) {
        Workbook workbook = WorkbookUtil.readExcel(file);
        Sheet sheet = workbook.getSheetAt(0);
        int lastNum = sheet.getLastRowNum();
        try {
            return SheetResolve.sheetHandle(sheet, start, lastNum, clazz);
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("error fail");
        }
        return new ArrayList<>();
    }
}
