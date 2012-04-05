<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>사용자 조회</title>
<meta http-equiv="contentType" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" href="../css/style.css" type="text/css"/>
</head>
hello, this is a "user/list" view.
<hr>


<form name="selectUserForm"
action="selectUsers.action"
method="post" >
  <td width="150">사용자 ID</td>
 <input type="text" name="userId"/>
  <td width="150">사용자 이름</td>
 <input type="text" name="userName"/>
 	<input type="submit" value="조회" />
</form>

<table>

	<tr>
	<th width="10">UserID</th>
	   <th width="90">UserName</th>
	   <th width="70">password</th>
	   <th width="90">deptName</th>

	</tr>
	<c:forEach items="${userList}" var="user">
			<tr>
				<td><a href="view.action?id=${user.userId}">${user.userId}</a></td>
				<td>${user.userName}</td>
				<td>${user.password}</td>

			</tr>
	</c:forEach>
</table>
<hr>
<a href = "../user/create.action">추가</a><br/>
</html>