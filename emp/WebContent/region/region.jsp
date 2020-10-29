<%@page import="javax.servlet.jsp.jstl.core.LoopTagStatus"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<meta charset="UTF-8">
<title>区域信息管理</title>
<link style="text/css" rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="main">
		<div class="head">
			<h1>企业信息管理系统</h1>
		</div>
		<div class="content">
			<div class="left">
				<ul>
					<li><a href="region/region.html">区域信息管理</a></li>
					<li><a href="depart/depart.html">部门信息管理</a></li>
					<li><a href="emp/emp.html">员工信息管理</a></li>
				</ul>
			</div>
			<div class="rigth">
			  <div class = "search">
			   <span>
				<input type="text" placeholder="请输入区域名称">
				<button>检索</button>
				<button onclick="javascript:window.location.href='region/addRegion.html'">添加</button>
			   </span>
			  </div>
				<table>
					<thead>
						<tr>
							<th>区域编号</th>
							<th>区域名称</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="region" items="${pageInfo.datas }"
							  varStatus="s">
							  <!-- varStatus代表迭代的状态。
							  		index: 当前迭代的位置，从0开始。
							  		current：代表当前迭代出来的对象。
							   -->
						<c:if test="${s.index%2==0 }">
							<tr class="odd">
						</c:if>
						<c:if test="${s.index%2!=0 }">
							<tr>
						</c:if>
							<td>${region.id}</td>
							<td>${region.name}</td>
							<td><button>编辑</button> <button>删除</button></td>
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3" align="right">
								<select name="pageSize" onchange="changeSize(this.value)">
									<option value="5">5</option>
									<option value="10">10</option>
									<option value="15">15</option>
									<option value="20">20</option>
								</select>
								<script type="text/javascript">
									var pageSize = ${pageInfo.pageSize};
									console.log("pageSize:"+pageSize);
									options = document.getElementsByTagName("option");
									for(var i = 0;i<options.length;i++){
										if(options[i].value==pageSize){
											options[i].selected="selected"
										}
									}
								</script>
								<span><a href="region/allRegion.do?pageNum=1&pageSize=${pageInfo.pageSize}">首　页</a></span>
								<c:if test="${pageInfo.hasPrePage }">
								<span><a href="region/allRegion.do?pageNum=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">前一页</a></span>
								</c:if>
								<c:if test="${pageInfo.hasNextPage }">
								<span><a href="region/allRegion.do?pageNum=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">后一页</a></span>
								</c:if>
								<span><a href="region/allRegion.do?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">末　页</a></span>
								共${pageInfo.total }条记录${pageInfo.pages }页
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div style="clear: both;"></div>
		<div class="footer">
			本系统最终解释权为briup所有。
		</div>
	</div>
</body>
<script type="text/javascript">
	function changeSize(pageSize){
		console.log("pageSize:"+pageSize);
		window.location.href="region/allRegion.do?pageNum=1&pageSize="+pageSize;
	}
</script>







</html>