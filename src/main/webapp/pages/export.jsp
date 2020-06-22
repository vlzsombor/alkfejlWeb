<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09/05/2020
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Export</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<p class="text-justify">
    <%=(hu.adatbazisokAlkfejl.controller.RecordController.getInstance().exportCode(request.getParameter("tableName")))%>
</p>

<a href="#" onclick="javascript:window.history.back(-1);return false;">Back</a>

</body>
</html>
