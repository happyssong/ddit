<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<style type="text/css">
	table, tr, td { border:1px solid blue; }
	td { padding:5px;}
</style>
<script type="text/javascript">

window.onload = function(){
	var btnAdd = document.getElementById("btnAdd");
	btnAdd.onclick = function(){
		location.href = "<%=request.getContextPath()%>/member/memberForm.do";
	}
};

</script>
</head>
<body>
<%
	List<MemberVO> memList = (List<MemberVO>)request.getAttribute("memberList");
%>
<h2>회원 목록 보기</h2>	
<table border="1">
	<thead>
		<tr>
			<td colspan="5" style="text-align:right;"><input type="button" id="btnAdd" value="회원추가"></td>
		</tr>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이 름</th>
			<th>전 화</th>
			<th>주 소</th>
		</tr>
	</thead>
	<tbody>
<%
	for(MemberVO memvo : memList){
%>
		<tr>
			<td><a href="<%=request.getContextPath()%>/member/memberView.do?mem_id=<%=memvo.getMem_id()%>"><%=memvo.getMem_id() %></a></td>
			<td><%=memvo.getMem_pass() %></td>
			<td><%=memvo.getMem_name() %></td>
			<td><%=memvo.getMem_tel() %></td>
			<td><%=memvo.getMem_addr() %></td>
		</tr>
<%
	}
%>
	</tbody>	

</table>
</body>
</html>