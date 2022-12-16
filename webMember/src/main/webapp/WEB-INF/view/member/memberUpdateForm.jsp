<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>

<style type="text/css">
	table, tr, td { border:1px solid blue; border-collapse: collapse; }
	td { padding:5px;}
</style>

<script type="text/javascript">

window.onload = function(){

	var btnList = document.getElementById("btnList");

	btnList.onclick = function(){
		location.href = "<%=request.getContextPath()%>/member/memberList.do";
	}
};

</script>
</head>
<body>
<%
	MemberVO memVo = (MemberVO)request.getAttribute("memberVo");
%>
<h2>회원 정보 수정 폼</h2>
<form action="<%=request.getContextPath()%>/member/memberUpdate.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="mem_id" value="<%=memVo.getMem_id()%>">
	<input type="hidden" name="old_photo" value="<%=memVo.getMem_photo() %>">
<table border="1">
<tbody>
	<tr>
		<td colspan="2" style="text-align:center;"><img src="<%=request.getContextPath() %>/images/imageSrcView.do?memID=<%=memVo.getMem_id() %>" width="200" height="140"></td>
	</tr>
	<tr>
		<td>회원ID</td>
		<td><%=memVo.getMem_id()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="mem_pass" value=""></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><input type="text" name="mem_name" value="<%=memVo.getMem_name()%>"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="mem_tel" value="<%=memVo.getMem_tel()%>"></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type="text" name="mem_addr" value="<%=memVo.getMem_addr()%>"></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type="file" name="mem_photo"></td>
	</tr>	
	<tr>
		<td colspan="2" style="text-align:center;"><input type="submit" value="저장"> <input type="reset" value="취소"> 
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>