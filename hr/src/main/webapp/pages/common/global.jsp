<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!-- jstl 标签的引入 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn"  %>

<%
String path = request.getContextPath();
String port = request.getServerPort()==80?"":":"+request.getServerPort();
String basePath = request.getScheme()+"://"+request.getServerName()+port+path+"/";
%>
<c:set value="<%=basePath %>" var="ctx"/>
<c:set var="moneyexp" value="#,##0.00#"></c:set>
<c:set var="moneyexpInt" value="#"></c:set>

<!-- 全局css的引入  -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/bootstrap.min.css?v=3.3.6" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/font-awesome.css?v=4.4.0" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/style.css?v=4.1.0" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/animate.css" />

<!-- 全局js的引入 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/bootstrap.min.js?v=3.3.6"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/contabs.js"></script>

<!-- 第三方插件 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/plugins/pace/pace.min.js"></script>

<%-- <script type="text/javascript" >
	//全局的ajax访问，处理ajax清求时sesion超时
	$.ajaxSetup({
		contentType:"application/x-www-form-urlencoded;charset=utf-8",
		complete:function(XMLHttpRequest,textStatus){
			//通过XMLHttpRequest取得响应头，sessionstatus，
			var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); 
			if(sessionstatus=="timeout"){
			//如果超时就处理 ，指定要跳转的页面
				window.location.reload("/lend-app-report/");
			}
			
			if(XMLHttpRequest.status==555){
				var location = XMLHttpRequest.getResponseHeader("Location");
				self.parent.window.location=location;
			}
		}
	});
</script> --%>

