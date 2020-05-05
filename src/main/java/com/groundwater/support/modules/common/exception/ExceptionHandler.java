package com.groundwater.support.modules.common.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author wensi
 */
@ControllerAdvice
public class ExceptionHandler {

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)//异常捕获与处理
//    @ResponseStatus(HttpStatus.OK)//使http返回的状态码是200
//    @ResponseBody//使之返回json格式数据
//    public Result handleException(HttpServletRequest request, Exception ex){
//
//        if (ex instanceof BaseException){
//            BaseException baseException = (BaseException) ex;
//            return ResultUtil.getError(baseException.getCode(),baseException.getMessage());
//        }else {
//            return ResultUtil.getError(MsgUtil.SYSTEM_EXCEPTION);
//
//        }
//
//    }


}
