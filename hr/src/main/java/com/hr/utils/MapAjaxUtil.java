/**  
 * @(#)MapAjaxUtil.java	  2016年9月18日 下午4:03:38
 *
 * Copyright 2016 一房网ERP, Inc. All rights reserved.
 * 一房网ERP PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.hr.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * @author lifangyu
 * @version V1.0
 */
public class MapAjaxUtil {

    /**
     * @param @param  return_code 返回状态的码 0:成功，10001：系统异常，其他的状态码可以根据情况来设计
     * @param @param  result_message 提示语言
     * @param @param  result_info 传递的对象，可以为null，对象
     * @param @return 设定文件o
     * @return Map 返回类型
     * @Title: getAppMap
     * @Description: TODO(返回APP接口使用使用的返回数据)
     */
    public static Map<String, Object> getAppMap(Integer result_code, String result_message, Object result_info) {
        Map<String, Object> map = new HashMap();
        map.put("result_code", result_code);
        map.put("result_message", result_message);
        map.put("result_info", result_info);
        return map;
    }

}
