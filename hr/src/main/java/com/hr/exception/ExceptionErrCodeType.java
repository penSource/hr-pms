package com.hr.exception;

/**
 * ECM
 * 
 * @category 操作错误码定义
 * @since
 * @version 1.0
 */
public enum ExceptionErrCodeType {
    /*
     * 
     */
    REQUEST_SUCCESS("0", "请求数据成功"),

    REQUEST_FAIL("1", "请求数据失败"),

    NOT_LOGIN("1001", "请登录"),

    REQUEST_PARAM_ERROE("2001", "请求参数出错"),

    REQUEST_PARAM_IS_NULL("3001", "请求的参数不可以为空"),

    DB_UNKNOWN_COLUMN_ERROR("4001", "有未知的字段"),

    REQUEST_PARAM_VERSION("9001", "更新版本号已变,请刷新后重新操作!");

    private String code;
    private String name;

    private ExceptionErrCodeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getStringCode() {
        return code;
    }

    public int getCode() {
        return Integer.valueOf(code);
    }

    public String getName() {
        return name;
    }

}