<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<html>
<head>
	<title>Export XML files</title>
</head>
<body>
<form name="exportXml" method="POST" action="/delegate/XmlServices/export" onsubmit="return validate();">
	<table>
		<tr>
			<td><label>Регулярное выражение:</label></td>
			<td><input type="text" name="regularEx"></td>
		<tr>
		<tr>
			<td colspan="2"><input type="submit" value="Выполнить"/></td>
		</tr>
	</table>
</form>

</body>
</html>

<script type="text/javascript">
	function validate() {
		valid = true;
		if (document.exportXml.regularEx.value == "") {
			alert("Пожалуйста заполните поле 'Регулярное выражение'!");
			valid = false;
		}
		var div = document.createElement('div');
		var img = document.createElement('img');
		img.src = '<%=request.getContextPath()%>/images/loader.gif';
		div.innerHTML = "Идет формирование xml файлов. Пожалуйста подождите...<br />";
		div.style.cssText = 'position: fixed; top: 50%; left: 40%; z-index: 5000; width: 422px; text-align: center; background: #EDDBB0; border: 1px solid #000';
		div.appendChild(img);
		document.body.appendChild(div);
		window.event.cancelBubble = true;
		stopPropagation()
		return valid;
	}
</script>