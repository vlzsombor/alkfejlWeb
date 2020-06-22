<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%-- Using JSTL forEach and out to loop a list and display items in table --%>
<table>
    <tbody>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${requestScope.empList}" var="emp">
        <tr>
            <td><c:out value="${emp.id}"></c:out></td>
            <td><c:out value="${emp.name}"></c:out></td>
            <td><c:out value="${emp.role}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>
<%-- simple c:if and c:out example with HTML escaping --%>
<c:if test="${requestScope.htmlTagData ne null }">
    <c:out value="${requestScope.htmlTagData}" escapeXml="true"></c:out>
</c:if>
<br><br>
<%-- c:set example to set variable value --%>
<c:set var="id" value="5" scope="request"></c:set>
<c:out value="${requestScope.id }"></c:out>
<br><br>
<%-- c:catch example --%>
<c:catch var="exception">
    <% int x = 5 / 0;%>
</c:catch>

<c:if test="${exception ne null}">
    <p>Exception is : ${exception} <br>
        Exception Message: ${exception.message}</p>
</c:if>
<br><br>
<%-- c:url example --%>
<a href="<c:url value="${requestScope.url }"></c:url>">JournalDev</a>
</body>
</html>