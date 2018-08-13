<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>정보수정</h1>
	<c:choose>
		<c:when test="${not empty member}">
	<form action="${pageContext.request.contextPath }/memberUpdate" method="post">

		<h1>${error }</h1>
		<tr>
			<td>
				이름:
			</td>
			<td>
				<input type="text" name="name" value="${member.name }"><br/>
			</td>
			<td>
				아이디:
			</td>
			<td>
				<input type="text" name="id" id="id" value="${member.id }"> <input type="button" value="아이디 중복체크 " name="idcheck" id="idcheck"> <br/>
			</td>
			<td>
				이메일:
			</td>
			<td>
				<input type="text" name="email" value="${member.email }"><br/>
			</td>
			
			<td>
				날짜:
			</td>
			<td>
				<input type="text" name="dob" value="${member.dob }"><br/>
			</td>
		</tr>
		<tr>			
			<td>
			
				<input type="submit" value="수정"><br/>
				
			</td>
		
		</tr>
	

	</form>
	</c:when>
	<c:otherwise>
		<div class="error">주어진 아이디가 잘못된 정보입니다.</div>
	</c:otherwise>
	</c:choose>
</body>
</html>