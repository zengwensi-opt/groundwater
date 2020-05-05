package com.groundwater.support.modules.common.exception;

import lombok.Data;

/**
 * @author wensi
 */
@Data
public class BaseException extends RuntimeException{
    private Integer code;

    public BaseException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

}
