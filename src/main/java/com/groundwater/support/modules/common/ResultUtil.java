package com.groundwater.support.modules.common;

/**
 * @author wensi
 */

public class  ResultUtil<T> {


    public static <T> Result<T> getSuccess(String message,T data){
        return new Result<T>(200, message, data);
    }

    public static <T> Result<T> getError(String message,T data){
        return new Result<>(400, message, data);
    }

    public static Result getError(String message){
        return new Result(400, message);
    }
    public static Result getError(Integer code,String message){
        return new Result(code, message);
    }
}
