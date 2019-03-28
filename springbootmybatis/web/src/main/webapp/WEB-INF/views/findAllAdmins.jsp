<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>姓名</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>状态</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="admins" >
            <tr >
                <td>${admins.name}</td>
                <td>${admins.createdAtStr}</td>
                <td>${admins.updatedAtStr}</td>
                <td>${admins.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
