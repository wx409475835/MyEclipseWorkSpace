<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<style type="text/css">
		span{
			font-family: '微软雅黑';
			font-size: 17px;
		}
	</style>

  </head>
  
  <body>
    <span>您所在的位置是:</span>
    <c:forEach var="p" items="${tree.parent }">
    	<span>${p.name } >>> </span>
    </c:forEach>
    
    <br/>
    <br/>
    <span>ID:${tree.id }</span> &nbsp;&nbsp;&nbsp;<span>分类名称:${tree.name }</span><br/>
    
    <br/>
    <br/>
    <br/>
    <form action="${pageContext.request.contextPath }/AddTree" method="post">
    	<input type="hidden" name="pid" value="${tree.id }"/>
    	<span>子节点:</span><input placeholder="请输入新节点的名称" type="text" name="name"/>&nbsp;
    	&nbsp;
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
