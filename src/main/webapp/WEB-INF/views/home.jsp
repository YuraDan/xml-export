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
			<td><label>Кадастровый номер:</label></td>
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
			alert("Пожалуйста заполните поле 'Кадастровый номер'!");
			valid = false;
		}
	}
</script>