<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>

$(document).ready(function() {
	
	
	$('#idcheck').click(function() {
		if ($('#id').val()) {
			
		
		 	$.ajax({
				type:"post",
				url:"/textex/reg1",
				data: {idcheck :$('#id').val()},
				success: function(data) {
					if (data != 0) {
						alert('사용할수있는 아이디입니다');
						
					}else{
						alert('사용할수 없는 아이디 입니다');
						$('#id').val("");
						$('#id').focus();
						
					}
					
				},
				error: function(xhr, status, error) {
		            alert(error);
		        }  	
			}); 

		}else{
			alert('id 를 입력하세요');
			 $("#id").focus();
			
			
		}
	});

	 });
</script>
</head>
<body>

	<h1>회원등록</h1>
		<form action="${pageContext.request.contextPath }/register" method="post"> 
		<table>	
			
		<h1>${error }</h1>
		<tr>
			<td>
				이름:
			</td>
			<td>
				<input type="text" name="name" id="name"><br/>
			</td>
		</tr>
		<tr>
		
			<td>
				아이디:
			</td>
			<td>
				<input type="text" name="id" id="id"> <input type="button" value="아이디 중복체크 " name="idcheck" id="idcheck"> <br/>
			</td>
			
		</tr>	
		<tr>
			<td>
				이메일:
			</td>
			<td>
				<input type="text" name="email"id="email"><br/>
			</td>
		</tr>
		<tr>	
			<td>
				날짜:
			</td>
			<td>
				<input type="date" name="dob"id="dob"><br/>
			</td>
		</tr>	
		
		<tr>			
			<td>
				<input type="submit" value="등록">
				
			</td>
		
		</tr>
		
	</table>
	</form>


</body>
</html>