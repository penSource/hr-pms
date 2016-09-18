/**  
 * @(#)CommonException.java	  2016年9月18日 下午4:09:00
 *
 * Copyright 2016 HR, Inc. All rights reserved.
 * HR PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.hr.exception;

/**
 * TODO
 * @author lifangyu
 * @version V1.0
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /** 异常码 */
    private String code;

    /** 异常描述 */
    private String message;

    /**
     * 构造异常
     * 
     * @param code 异常码
     * @param message 异常描述
     */
    public CommonException(String code, String message, Exception e) {
        super(code, e);
        this.code = code;
        this.message = message;
    }

    /**
     * 构造异常
     * 
     * @param code 异常码
     * @param message 异常描述
     */
    public CommonException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return code + ": " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
