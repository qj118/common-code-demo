package org.demon.excel2entity.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:48
 */
public interface ImportService {

    void importBook(MultipartFile file);
}
