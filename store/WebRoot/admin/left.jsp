<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>图灵工作室网上商城管理中心菜单</title>
	<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
	<table width="100" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="12"></td>
	  </tr>
	</table>
	<table width="100%" border="0">
	  <tr>
	    <td>
			<div class="dtree">	
				<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>			
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
				<script type="text/javascript">
					
					d = new dTree('d');
					d.add('01',-1,'系统菜单树');
					d.add('0101','01','用户管理','','','mainFrame');
					d.add('010101','0101','用户管理','${pageContext.request.contextPath}/userAdmin?method=findAll&currPage=1','','mainFrame');
					d.add('0102','01','分类管理','','','mainFrame');
					d.add('010201','0102','分类管理','${pageContext.request.contextPath}/adminCategory?method=findAll','','mainFrame');
					d.add('0104','01','商品管理');
					d.add('010401','0104','商品管理','${pageContext.request.contextPath}/adminProduct?method=findAll&currPage=1','','mainFrame');
					d.add('0105','01','订单管理');
					d.add('010501','0105','所有订单','${pageContext.request.contextPath}/adminOrder?method=findAll&currPage=1','','mainFrame');
					d.add('010502','0105','未支付订单','${pageContext.request.contextPath}/adminOrder?method=NotPay&currPage=1&state=0','','mainFrame');
					d.add('010503','0105','已支付订单','${pageContext.request.contextPath}/adminOrder?method=HadPay&currPage=1&state=1','','mainFrame');
					d.add('010504','0105','已发货订单','${pageContext.request.contextPath}/adminOrder?method=HadStart&currPage=1&state=2','','mainFrame');
					d.add('010505','0105','已完成订单','${pageContext.request.contextPath}/adminOrder?method=HadFinish&currPage=1&state=3','','mainFrame');
					document.write(d);
				</script>
			</div>	
		</td>
	  </tr>
	</table>
</body>
</html>

<!--
					左边的dtree:
					1.导入dtree.js
					2.导入dtree.css
					3.创建一个div 添加样式 class="dtree"
					4.在div中编写js代码
						创建一个树
							d = new dTree('d');
						添加根节点
							通过 d.add(当前节点的id,父节点的id,显示的名称,点击时候打开的连接,放上去显示的名称,在那个地方打开这个连接)
							注意:
								根节点的父节点的id写成-1
						添加其他节点
					5.最后通过document.write(d) 写到页面上即可
				分类信息添加:
					1.应在在左边的dtree上添加连接(展示所有的分类信息)
						d.add(...,"/store/adminCategory?method=findAll","","mainFrame")
					2.创建adminCategoryservlet ,编写findAll()
						查询的结果是一个list,将list放入request域中,然后请求转发/admin/category/list.jsp
					
				-->
