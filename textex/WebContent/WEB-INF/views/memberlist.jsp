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

<table border="1">
		<c:forEach items="${member }" var="member">
		<tr>
			<td>
			${member.id }
			</td>
			<td>
			${member.name }
			</td>
			<td>
			${member.dob }
			</td>
			<td>
			${member.email }
			</td>
			<td>
			<a href="${pageContext.request.contextPath }/memberUpdate?id=${member.id }">회원정보수정</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath }/memberdelete">회원탈퇴</a>
			</td>
		</tr>
		


		</c:forEach>
</table>





</body>
</html>