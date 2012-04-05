<%@page contentType="text/html; charset=UTF-8"%><%@
taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>사용자 등록</title>
<hr>
<SCRIPT language='JavaScript' type='text/javascript'>
		function submit()
		{
			document.systemUserForm.submit();
			return;
		}
	</SCRIPT>

<link rel="stylesheet" href="../css/style.css" type="text/css"/>
</head>

<form name="systemUserForm" action="insert.action" method="post" >
<table border=1 width="700" cellspacing=0>
	    <tr>
	        <td width="150">사용자 ID</td>
	        <td colspan="3">
	         <input type="text" name="userId"/>
			</td>
	    </tr>

	    <tr>
	        <td>사용자이름</td>
	        <td  width="150">
	        <input type="text" name="userName" />
			</td>

	    </tr>
	    <tr>
	        <td>password</td>
	        <td colspan=3>
			<input type="text" name="password" />
			</td>
	    </tr>


	</table>
	<input type="submit" value="저장" />
</form>

<hr>