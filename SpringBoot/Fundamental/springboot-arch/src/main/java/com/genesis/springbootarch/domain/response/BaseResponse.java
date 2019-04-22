package com.genesis.springbootarch.domain.response;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:29 PM 2019/4/13
 * @modified by:
 */

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    protected String code;
    protected String message;
    protected String exception;
    protected T data;

    public BaseResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
