<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09/05/2020
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<table class="table table-bordered">

    <thead>
<c:if test = "${requestScope.tableName != null}">
    <tr>
        <c:forEach items="${requestScope.columnNameList}" var="emp">
            <th scope="col">
                <a href="/adatbazisokAlkFejlWeb_war/pages/columnRename.jsp?tableName=${emp}"
                   class="btn btn-primary"><c:out value="${emp}"></c:out></a>
            </th>
        </c:forEach>
    </tr>
</c:if>
    </thead>
    <tbody>

    <c:forEach items="${requestScope.recordList}" var="empX">
        <tr>
            <c:forEach items="${empX.values}" var="empZ">
                <td><c:out value="${empZ}"></c:out></td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test = "${requestScope.tableName != null}">
<a href="/adatbazisokAlkFejlWeb_war/pages/export.jsp?tableName=${requestScope.tableName}"
   class="btn btn-primary">Export</a>
</c:if>

<c:if test = "${requestScope.tableName == null && requestScope.recordList == null}">
    Nincs talalat
</c:if>


<a href="#" onclick="javascript:window.history.back(-1);return false;">Back</a>
</body>
</html>
