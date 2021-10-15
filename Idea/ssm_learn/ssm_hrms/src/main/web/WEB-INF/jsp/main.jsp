<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Chrome">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>my first one</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="hrms_container">
    <%-- 导航条 --%>
    <%@include file="./commom/head.jsp"%>

    <%-- 中间部分 左边栏 --%>
    <div class="hrms_body" style="position: relative; top: -15px;">

        <%-- 左边栏 --%>
        <%@include file="./commom/leftsidebar.jsp"%>

        <%-- 中间轮播图片 --%>
        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 style="text-align: center;">欢迎进入xxx公司</h3>
                </div>
                <div class="panel-body" style="position: relative; top: -15px;">
                    <div id="hrms_carousel_1 " class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#hrms_carousel_1" data-slide-to="0" class="active"></li>
                            <li data-target="#hrms_carousel_1" data-slide-to="1" ></li>
                            <li data-target="#hrms_carousel_1" data-slide-to="2" ></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <div class="item active" style="text-align: center">
                                <img class="img-respinsive center-block" src="/static/img/company1.jpg" alt="company1">
                                <div class="carousel-caption">
                                    <h3>办公楼</h3>
                                </div>
                            </div>
                                <div class="item">
                                    <img class="img-responsive center-block" src="/static/img/company2.jpg" alt="company2.jpg">
                                    <div class="carousel-caption">
                                        <h3>休闲场所</h3>
                                    </div>
                                </div>
                                <div class="item">
                                    <img class="img-responsive center-block" src="/static/img/company3.jpg" alt="company3.jpg">
                                    <div class="carousel-caption">
                                        <h3>办公环境</h3>
                                    </div>
                                </div>
                            </div>

                             <%-- Controls --%>
                            <a class="left carousel-control" href="#chrms_carousel_1" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#hrms_carousel_1 " role="button">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"  ></span>
                                <span class="sr-only">Next</span>
                            </a>

                    </div><!-- /#hrms_carousel_1 -->
                </div><!-- /.panel-body -->
            </div><!-- /.panel -->
        </div><!-- /.hrms_main_ad -->
    </div><!-- /.hrms_body -->

    <%-- 尾部 --%>
    <%@include file="./commom/foot.jsp"%>
</div><!-- /.hrms_container -->
</body>
</html>
