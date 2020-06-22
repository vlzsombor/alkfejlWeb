<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>


<form action="upload" method="post" enctype="multipart/form-data">
    <div class="file-field">
        <div class="btn btn-primary btn-sm float-left">
            <span>Choose file</span>
            <input type="file" name="file" accept=".db" >
        </div>
        <div class="file-path-wrapper">
            <input class="btn btn-warning" type="submit" />
        </div>
    </div>
</form>

</body>
</html>

