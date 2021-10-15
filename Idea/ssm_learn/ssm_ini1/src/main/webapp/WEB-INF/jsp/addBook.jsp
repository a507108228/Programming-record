<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 -- 增加书籍 </small>
                </h1>
            </div>
        </div>
    </div>



            <form action="${pageContext.request.contextPath}/book/addBook" method="post">
                <div class="form-group">
                    <label for="exampleInputname">书籍名称：</label>
                    <input type="text" class="form-control" id="exampleInputname" name="bookname" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputcounts">书籍数量：</label>
                    <input type="text" class="form-control" id="exampleInputcounts" name="bookcounts" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputdetail">书籍详情：</label>
                    <input type="text" class="form-control" id="exampleInputdetail" name="detail" required>
                </div>

                <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <input type="file" id="exampleInputFile">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>


</div>
</body>
</html>
