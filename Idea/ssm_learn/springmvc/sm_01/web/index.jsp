<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="sm_01/testRedirect">Test Redirect</a>
	<br><br>

	<a href="sm_01/testView">Test View</a>
	<br><br>

	<a href="sm_01/testViewAndViewResolver">Test ViewAndViewResolver</a>
	<br><br>
	
	<!--  
		模拟修改操作
		1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
	<form action="sm_01/testModelAttribute" method="Post">
		<input type="hidden" name="id" value="1"/>
		username: <input type="text" name="username" value="Tom"/>
		<br>
		email: <input type="text" name="email" value="tom@atguigu.com"/>
		<br>
		age: <input type="text" name="age" value="12"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>

	<a href="sm_01/testSessionAttributes">Test SessionAttributes</a>
	<br><br>

	<a href="sm_01/testMap">Test Map</a>
	<br><br>

	<a href="sm_01/testModelAndView">Test ModelAndView</a>
	<br><br>

	<a href="sm_01/testServletAPI">Test ServletAPI</a>
	<br><br>

	<form action="sm_01/testPojo" method="post">
		username: <input type="text" name="username"/>
		<br>
		password: <input type="password" name="password"/>
		<br>
		email: <input type="text" name="email"/>
		<br>
		age: <input type="text" name="age"/>
		<br>
		city: <input type="text" name="address.city"/>
		<br>
		province: <input type="text" name="address.province"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>

	<a href="sm_01/testCookieValue">Test CookieValue</a>
	<br><br>

	<a href="sm_01/testRequestHeader">Test RequestHeader</a>
	<br><br>
	
	<a href="sm_01/testRequestParam?username=atguigu&age=11">Test RequestParam</a>
	<br><br>
	
	<form action="sm_01/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="TestRest PUT"/>
	</form>
	<br><br>
	
	<form action="sm_01/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="TestRest DELETE"/>
	</form>
	<br><br>
	
	<form action="sm_01/testRest" method="post">
		<input type="submit" value="TestRest POST"/>
	</form>
	<br><br>
	
	<a href="sm_01/testRest/1">Test Rest Get</a>
	<br><br>

	<a href="sm_01/testPathVariable/1">Test PathVariable</a>
	<br><br>

	<a href="sm_01/testAntPath/mnxyz/abc">Test AntPath</a>
	<br><br>

	<a href="sm_01/testParamsAndHeaders?username=atguigu&age=10">Test ParamsAndHeaders</a>
	<br><br>
	
	<form action="sm_01/testMethod" method="POST">
		<input type="submit" value="submit"/>
	</form>

	<br><br>
	<a href="sm_01/testMethod">Test Method
	没有指定post 方法确是post请求所以报错 解决方法是上面指定post方式 submit运行成功</a>

	<br><br>
	<a href="sm_01/testRequestMapping">Test RequestMapping</a>
	
	<br><br>
	<a href="helloworld">Hello World</a>
	
</body>
</html>