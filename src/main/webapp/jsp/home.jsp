<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Config Lab</title>
<link href="../css/home.css" rel="stylesheet" />
<link href="../metro/css/metro.min.css" rel="stylesheet" />

</head>
<body>
	Hello World
	Test
		<br />
	<s:iterator value="homeBean.categoryLst">
		<s:property value="CategoryID" /> -	<s:property value="CategoryName" />
			<br />
	</s:iterator>
</body>
</html>
