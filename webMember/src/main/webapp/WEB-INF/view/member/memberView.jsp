<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"/>
<title>Insert title here</title>

<style type="text/css">
	table, tr, td { border:1px solid blue; border-collapse: collapse; }
	td { padding:5px;}
</style>

<script type="text/javascript">

window.onload = function(){
	var btnUpdate = document.getElementById("btnUpdate");
	var btnDelete = document.getElementById("btnDelete");
	var btnList = document.getElementById("btnList");
	
	btnUpdate.onclick = function(){
		var form = document.getElementById("memberForm");
		form.action = "<%=request.getContextPath()%>/member/memberUpdateForm.do";
		form.submit();
	}
	btnDelete.onclick = function(){
		var form = document.getElementById("memberForm");
		form.action = "<%=request.getContextPath()%>/member/memberDelete.do";
		form.submit();
	}
	btnList.onclick = function(){
		location.href = "<%=request.getContextPath()%>/member/memberList.do";
	}
};

</script>
</head>
<body>
<% 	MemberVO memVo = (MemberVO)request.getAttribute("memberVo"); %>
<h2>회원 정보 상세보기</h2>
<form name="memberForm" id="memberForm" >
	<input type="hidden" id="mem_id" name="mem_id" value="<%=memVo.getMem_id()%>">
<table border="1">
<tbody>
	<tr>
		<td colspan="2" style="text-align:center;"><img src="<%=request.getContextPath() %>/images/imageSrcView.do?memID=<%=memVo.getMem_id() %>" width="200" height="140"></td>
	</tr>
	<tr>
		<td>회원ID</td><td><%=memVo.getMem_id()%></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><%=memVo.getMem_pass()%></td>
	</tr>
	<tr>
		<td>회원이름</td><td><%=memVo.getMem_name()%></td>
	</tr>
	<tr>
		<td>전화번호</td><td><%=memVo.getMem_tel()%></td>
	</tr>
	<tr>
		<td>회원주소</td><td><%=memVo.getMem_addr()%></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input id="btnUpdate" type="button" value="수정"> 
			<input id="btnDelete" type="button" value="삭제"> 
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form></body></html>