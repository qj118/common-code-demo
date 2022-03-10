package org.demon.excel2entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demon.excel2entity.utils.annotation.Column;

import java.math.BigDecimal;

/**
 * Create by Qu Jin
 * Date 2022/3/9 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportBookDTO {

    @Column(index = 0)
    private String name;

    @Column(index = 1)
    private String author;

    @Column(index = 2, type = BigDecimal.class)
    private BigDecimal price;
}
