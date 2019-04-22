package com.genesis.springbootarch.controller.advice;

import com.genesis.springbootarch.domain.constants.CodeMsg;
import com.genesis.springbootarch.domain.response.BaseResponse;
import com.genesis.springbootarch.domain.response.ExceptionResponse;
import com.genesis.springbootarch.util.LogUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: KG
 * @description:
 * @date: Created in 8:18 PM 2019/4/22
 * @modified by:
 */

@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public BaseResponse<Integer> nullPointerException(Exception e) {
        BaseResponse<Integer> response = new BaseResponse();
        response.setCode(CodeMsg.NULL_POINTER_EXCEPTION.CODE);
        response.setMessage((CodeMsg.NULL_POINTER_EXCEPTION.MSG));
        response.setException(e.getMessage());

        LogUtil.info(String.format("Exception Caught: %s", CodeMsg.NULL_POINTER_EXCEPTION.MSG));

        e.printStackTrace();

        return response;
    }
}

