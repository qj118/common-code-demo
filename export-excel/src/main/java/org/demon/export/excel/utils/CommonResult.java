package org.demon.export.excel.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create by Qu Jin
 * Date 2022/3/11 9:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private Boolean status;
    private int code;
    private String msg;
    private T content;

    public static CommonResult ok(String msg){
        return new CommonResult(true, 10000, msg);
    }

    public static CommonResult error(String msg){
        return new CommonResult(false, 10001, msg);
    }

    public CommonResult(boolean status, int code, String msg){
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.content = null;
    }

    public CommonResult(T content){
        this.content = content;
    }
}
