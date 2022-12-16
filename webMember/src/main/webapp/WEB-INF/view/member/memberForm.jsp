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

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">

// window.onload = function(){

// 	var btnList = document.getElementById("btnList");

// 	btnList.onclick = function(){
<%-- 		location.href = "<%=request.getContextPath()%>/member2/memberList.do"; --%>
// 	}
// };
$(function(){
	$("#btnList").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberList.do";
	});
	
	$("#idCheck").on("click", function(){
		var memId = $("#mem_id").val();
		if(memId==""){
			alert("ID를 입력하세요");
			return;
		}
		$.ajax({
	    	 url : '<%=request.getContextPath()%>/member/memberIdCheck.do',
	    	 data : { "mem_id" : memId },
	    	 dataType : 'json',
	    	 success : function(result){
	    		 if(result=="OK"){
	    			 $("#idChkResult").html("사용가능");
	    		 }else{
	    			 $("#idChkResult").html("ID 중복 - 사용불가");
	    		 }
	    	 },
	    	 error : function(xhr){
	    		 alert("status :" + xhr.status);
	    	 }
	     })
	});
	
	$("#memberForm").on("submit", function(){
		var idchk = $("#idChkResult").html();
		if(idchk!="사용가능"){
			alert("ID 중복되거나 중복체크를 하지 않았습니다.");
			return false;  // 전송 중단.
		}
		if($("#mem_pass").val()!= $("#mem_pass2").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다. 다시 확인하세요.");
			return false;
		}
		
		return true;
	});
});

</script>
</head>


<body>
<h2>회원 정보 입력 폼</h2>
<form id="memberForm" method="post" action="<%=request.getContextPath()%>/member/memberInsert.do" enctype="multipart/form-data">
<table border="1">
<tbody>
	<tr>
		<td>회원ID</td>
		<td>
			<input type="text" name="mem_id" id="mem_id">
			<input id="idCheck" type="button" value="중복확인"><br>
			<span id="idChkResult"></span>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="mem_pass" id="mem_pass"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="password" name="mem_pass2" id="mem_pass2"></td>
	</tr>	
	<tr>
		<td>회원이름</td>
		<td><input type="text" name="mem_name"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="mem_tel"></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type="text" name="mem_addr"></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type="file" name="mem_photo"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장"> <input type="reset" value="취소">
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>