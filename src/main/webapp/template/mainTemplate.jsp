<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10,IE=9; IE=8; IE=7; IE=EDGE" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="../js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
/*reload if caching*/
$(window).bind("pageshow", function(event) {
    if (event.originalEvent.persisted) {
        window.location.reload();
    }
});
</script>
</head>
<body>
	<div class="body">
		<tiles:insertAttribute name="body" />
	</div>

</body>
</html>