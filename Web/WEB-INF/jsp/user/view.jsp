<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="business.sample.user.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head><title>사용자 정보 조회</title>
<SCRIPT language='JavaScript' type='text/javascript'>
		function submit()
		{
			document.userForm.submit();
			return;
		}
	</SCRIPT>


</head>
<link rel="stylesheet" href="../css/style.css" type="text/css"/>
hello, this is a "user/view" view.
<hr>
<body>
<form method="post"  name="userForm" action="update.action" >
	<table border=1 width="700" cellspacing=0>
	    <tr>
	        <td width="150">사용자 이름</td>
	        <td colspan="3">
	         <input type="text" name="userId"  value='<c:out value="${user.userId}"/>'/>
			</td>
	    </tr>

	    <tr>
	        <td>요청자 정보(사번/이름)</td>
	        <td  width="150">
	        <input type="text" name="userName"  value='<c:out value="${user.name}"/>'/>
			</td>

	    </tr>
	    <tr>
	        <td>password</td>
	        <td colspan=3>
			<input type="text" name="password"  value='<c:out value="${user.password}"/>'/>
			</td>
	    </tr>



	</table>
	<input type="submit" value="저장" />
	</form>
	<br>
<a href="delete.action?userId=${user.userId}">삭제</a>

<a href="selectUsers.action">목록으로..</a>
</body>
</html>
