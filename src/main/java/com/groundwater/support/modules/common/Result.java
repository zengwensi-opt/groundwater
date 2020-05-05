package com.groundwater.support.modules.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wensi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
