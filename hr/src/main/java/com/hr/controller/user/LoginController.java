/**  
 * @(#)LoginController.java	  2016年9月18日 下午4:23:30
 *
 * Copyright 2016 一房网ERP, Inc. All rights reserved.
 * 一房网ERP PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.hr.controller.user;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.controller.BaseController;

/**
 * 登录controller
 * @author lifangyu
 * @version V1.0
 */
@Controller
public class LoginController extends BaseController<LoginController> {

    @RequestMapping(value = { "login", "main" }, method = RequestMethod.POST)
    public String login() throws IOException {
        // 进入pages/main.jsp页面
        // 记住密码处理
        return "main";
    }
}
