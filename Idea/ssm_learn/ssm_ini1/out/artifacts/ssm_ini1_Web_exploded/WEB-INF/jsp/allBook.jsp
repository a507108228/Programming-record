<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 -- 显示所有书籍 </small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示</a>
        </div>

        <div class="col-md-4 column"></div>

        <div class="col-md-4 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                <span style="color: red; font-weight: bold">${error}</span>
                <input type="text" name="queryBookByName" placeholder="请输入书籍的名称">
                <input class="btn btn-primary" type="submit" value="查询">
            </form>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">

                <therd> <%-- 表格的头 存放标题 --%>
                    <tr>
                        <th>1</th>
                        <th>2</th>
                        <th>3</th>
                        <th>4</th>
                        <th>5</th>
                    </tr>
                </therd>

                <%-- tr: 保证高度 决定行高
                     td: 保证长度 决定行长 每一个td都是从左到右进行填充--%>
                <tbody> <%-- 表格主体存放内容 --%>
                <c:forEach var="book" items="${requestScope.get('list')}">
                    <tr>
                        <td>${book.getBookid()}</td>
                        <td>${book.getBookname()}</td>
                        <td>${book.getBookcounts()}</td>
                        <td>${book.getDetail()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookid()}">更改</a>
                            <a href="${pageContext.request.contextPath}/book/del/${book.getBookid()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>

</div>

</body>
</html>
