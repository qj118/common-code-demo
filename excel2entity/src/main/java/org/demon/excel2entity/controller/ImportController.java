package org.demon.excel2entity.controller;

import org.demon.excel2entity.service.ImportService;
import org.demon.excel2entity.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:54
 */
@RestController
public class ImportController {

    @Autowired
    private ImportService importService;

    @PostMapping("/import/books")
    public CommonResult importBooks(@RequestParam MultipartFile file){
        try{
            importService.importBook(file);
        }catch(Exception e){
            return CommonResult.error(e.getMessage());
        }
        return CommonResult.ok("import_book_success");
    }
}
