<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加书籍</title>

    <%--bootstrap css--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>

    <dir class="container">

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>新增书籍</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label>书籍名称：</label>
                <input type="text" name="bookName" class="form-control" required="true" autofocus>
            </div>
            <div class="form-group">
                <label>书籍数量：</label>
                <input type="text" name="bookCounts" class="form-control" required="true">
            </div>
            <div class="form-group">
                <label>书籍详情：</label>
                <input type="text" name="detail" class="form-control" required="true">
            </div>
            <div class="form-group">
                <input type="submit" value="添加" class="btn btn-primary">
            </div>

        </form>


    </dir>

</body>
</html>
