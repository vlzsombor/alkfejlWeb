<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10/05/2020
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ColumnRename</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<form action="/adatbazisokAlkFejlWeb_war/renameColumn?tableName=<%=request.getParameterMap().get("tableName")[0]%>"
      method="post">
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Uj oszlopnev</label>
        <textarea name="textarea1" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <input class="btn btn-primary" type="submit" value="Atnevezes">
</form>
<a href="#" onclick="javascript:window.history.back(-1);return false;">Back</a>
</body>
</html>
