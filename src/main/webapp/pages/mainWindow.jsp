<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 08/05/2020
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<table>
    <tbody>
    <c:forEach items="${requestScope.tablesNameList}" var="emp">
        <tr>
            <td><a href="table?tableName=${emp}" class="btn btn-info" role="button"><c:out value="${emp}"></c:out></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>

<form action="/adatbazisokAlkFejlWeb_war/customQuery" method="post">
    <div class="form-group">
        <textarea name="textarea1" class="form-control" id="FormControlTextarea1" rows="3"></textarea>
    </div>
    <input class="btn btn-primary" type="submit" value="Lekerdezes lefuttatasa">
</form>

<a href="/adatbazisokAlkFejlWeb_war/">Masik adatbazis feltoltese</a>

</body>
</html>
