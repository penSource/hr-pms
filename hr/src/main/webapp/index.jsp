<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/pages/common/global.jsp"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>人力资源管理系统 -登录</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="static/img/favicon.ico">
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>
<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>
				<h1 class="logo-name">H+</h1>
			</div>
			<h3>欢迎使用人力资源管理系统</h3>
			<form class="m-t" role="form" action="login" method="post">
				<div class="form-group">
					<input type="email" class="form-control" placeholder="用户名" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码"	required>
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登
					录</button>

				<p class="text-muted text-center">
					<a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
