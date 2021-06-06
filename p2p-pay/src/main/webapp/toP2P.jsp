<%--
  Created by IntelliJ IDEA.
  User: bob
  Date: 2021/6/5
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>疯狂加载中......</title>
</head>
<body>
  <form action="${alipay_return_url}" method="post">
    <input value="${signVerified}" name="signVerified" type="hidden"/>
        <c:choose>
            <c:when test="${not empty params}">
                <c:forEach items="${params}" var="paramMap">
                    <input value="${paramMap.value}" name="${paramMap.key}" type="hidden"/>
                </c:forEach>
            </c:when>
        </c:choose>
  </form>
  <script>document.forms[0].submit();</script>
</body>
</html>
