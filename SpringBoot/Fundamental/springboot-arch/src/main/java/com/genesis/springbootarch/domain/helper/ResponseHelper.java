package com.genesis.springbootarch.domain.helper;

import com.genesis.springbootarch.domain.constants.CodeMsg;
import com.genesis.springbootarch.domain.response.BaseResponse;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:35 PM 2019/4/13
 * @modified by:
 */

public class ResponseHelper {
    public ResponseHelper() {
    }

    public static <T> void success(BaseResponse<T> response, T data) {
        response.setCode(CodeMsg.SUCC.CODE);
        response.setMessage(CodeMsg.SUCC.MSG);
        response.setData(data);
    }

    public static <T> void fail(BaseResponse<T> response, String code, String message) {
        response.setCode(code);
        response.setMessage(message);
    }

    public static <T> void except(BaseResponse<T> response, String cause) {
        response.setCode(CodeMsg.EXCEPT.CODE);
        response.setMessage(CodeMsg.EXCEPT.MSG);
        response.setException(cause);
    }
}

