package org.demon.export.excel.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Create by Qu Jin
 * Date 2022/3/11 9:30
 */
@Slf4j
public class ResponseUtil {

    private ResponseUtil(){}
    /**
     * 将文件数据写入到响应流中,并返回给前端
     * @param response 本次操作的响应流
     * @param workbook
     * @param fileName 文件名
     */
    public static void writeToResponse(HttpServletResponse response, Workbook workbook, String fileName) {
        OutputStream outputStream = null;
        try {
            if(workbook instanceof HSSFWorkbook){
                setResponseHeader(response, fileName);
            }
            if(workbook instanceof XSSFWorkbook){
                setResponseHeaderX(response, fileName);
            }
            outputStream = response.getOutputStream();
            //将excel文档写入到响应流中
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.info("[project-log.ClassLoaderUtil]:{}", e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                log.info("[project-log.ClassLoaderUtil]:{}", e);
            }
        }
    }

    /**
     * 设置reponse的头部信息，返回 xls 文件
     * @param response 本次的响应流
     * @param fileName 文件名
     * @throws UnsupportedEncodingException
     */
    private static void setResponseHeader(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
    }

    /**
     * 返回 xlsx 文件
     * @param response
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    private static void setResponseHeaderX(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
    }
}
