<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<form action="${pageContext.request.contextPath}/book/updateBook" method="post">
    <input type="hidden" name="bookid" value="${book.bookid}">
    书籍名称：<input type="text" name="bookname" value="${book.bookname}"> <br> <br> <br>
    书籍数量：<input type="text" name="bookcounts" value="${book.bookcounts}" > <br> <br> <br>
    书籍详情：<input type="text" name="detail" value="${book.detail}" > <br> <br> <br>
    <input type="submit" value="更新">
</form>
</body>
</html>
