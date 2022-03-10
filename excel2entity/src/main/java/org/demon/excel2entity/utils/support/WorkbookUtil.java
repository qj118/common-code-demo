package org.demon.excel2entity.utils.support;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:31
 */
@Slf4j
public class WorkbookUtil {

    private WorkbookUtil() {}

    /**
     * 将数据流转成Workbook对象
     *
     * @param file
     * @return
     */
    public static Workbook readExcel(MultipartFile file) {
        try (
                InputStream is = file.getInputStream();
                Workbook workbook = WorkbookFactory.create(is)
        ) {
            return workbook;
        } catch (IOException e) {
            log.error("", e.getStackTrace());
        }
        return null;
    }
}
