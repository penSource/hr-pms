/**  
 * @(#)BaseController.java	  2016年9月18日 下午3:59:02
 *
 * Copyright 2016 HR, Inc. All rights reserved.
 *  HR PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.hr.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hr.constant.SessionKeys;
import com.hr.exception.CommonException;
import com.hr.exception.ExceptionErrCodeType;
import com.hr.utils.DateEditor;
import com.hr.utils.MapAjaxUtil;
import com.hr.utils.PropertiesUtils;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

/**
 * TODO
 * @author lifangyu
 * @version V1.0
 */
public class BaseController<T extends BaseController<T>> {

    private Class<T> subclass;

    protected Logger logger = null;

    @Autowired
    public HttpSession session;

    @Autowired
    public HttpServletRequest request;

    @SuppressWarnings("unchecked")
    public BaseController() {
        subclass = ((Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass()))
                .getActualTypeArguments()[0]);
        logger = LoggerFactory.getLogger(subclass);
    }

    @ResponseBody
    @ExceptionHandler
    public JSON exception(HttpServletRequest request, Exception e) {

        // 添加自己的异常处理逻辑，如日志记录
        logger.error("", e);

        Map<String, Object> map = null;

        int errorCode = 0;

        // 根据不同的异常类型进行不同处理

        if (e instanceof BadSqlGrammarException) {
            BadSqlGrammarException bException = (BadSqlGrammarException) e;
            if (bException.getCause() instanceof MySQLSyntaxErrorException) {
                MySQLSyntaxErrorException mysqlEx = (MySQLSyntaxErrorException) bException.getCause();
                errorCode = mysqlEx.getErrorCode();
            }
            map = MapAjaxUtil.getAppMap(errorCode, ExceptionErrCodeType.DB_UNKNOWN_COLUMN_ERROR.getName(),
                    e.getMessage());
        }

        if (e instanceof MySQLIntegrityConstraintViolationException) {
            MySQLIntegrityConstraintViolationException mysqlEx = (MySQLIntegrityConstraintViolationException) e;
            map = MapAjaxUtil.getAppMap(mysqlEx.getErrorCode(), "数据库查询出错", mysqlEx.getMessage());

        }

        if (e instanceof IllegalArgumentException) {
            IllegalArgumentException argument = (IllegalArgumentException) e;
            map = MapAjaxUtil.getAppMap(errorCode, ExceptionErrCodeType.DB_UNKNOWN_COLUMN_ERROR.getName(),
                    argument.getMessage());
        }

        if (e instanceof NullPointerException) {
            NullPointerException nnullEx = (NullPointerException) e;
            map = MapAjaxUtil.getAppMap(Integer.valueOf(errorCode), nnullEx.getMessage(), "数据不可以为空");
        }

        if (e instanceof CommonException) {
            CommonException ifangEx = (CommonException) e;
            logger.error(ifangEx.getCode(), e);
            map = MapAjaxUtil.getAppMap(Integer.valueOf(ifangEx.getCode()), ifangEx.getMessage(), e.getMessage());
        }
        if (map == null) {
            map = MapAjaxUtil.getAppMap(10000, "出现末捕获的异常错误！", e.getMessage());
        }

        return new JSONObject(map);
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object missingParamterHandler(HttpServletRequest request, HttpServletResponse response,
            final MissingServletRequestParameterException e) {

        logger.error("", e);

        String pathInfo = request.getRequestURI();

        logger.info("请求的路径为：{}", pathInfo);

        String paramName = e.getParameterName();

        logger.info("请求的参数名为：{}", paramName);

        String paramType = e.getParameterType();

        logger.info("请求的参数类型为：{}", paramType);

        String message = PropertiesUtils.getString(paramName);
        if (StringUtils.isEmpty(message)) {
            message = PropertiesUtils.getString("paramNotNull");
        }

        String[] messages = message.split("&");

        logger.info("提示信息为：{}", message);

        Map<String, Object> map = MapAjaxUtil.getAppMap(Integer.valueOf(messages[0]), messages[1], e.getMessage());

        return new JSONObject(map);

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // 注册一个自定义的处理类
        // 使用DateEditor来处理Date类型的日期转换
        // 即将Spring默认处理日期的类型换成DateEditor
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    public Object getUser() {
        Object attribute = session.getAttribute(SessionKeys.UserSessionKeys.SESSION_USER);
        if (attribute != null) {
            return (Object) attribute;
        }
        return null;
    }

    /**
     * 
     * TODO 等到当前访问的地址<br>
     * eg:http://127.0.0.1:8080/
     * @author lifangyu
     * @return
     *      String
     */
    public String getBasePath() {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/";
    }

}
