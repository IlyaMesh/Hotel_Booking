<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 23.12.2019
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <h2>Staff</h2>

    <ul class="list-group">
        <c:forEach items="${staff}" var="hotel">
            <a href="${pageContext.request.contextPath}/staff?hotel_id=${staff.hotel_id}" class="list-group-item list-group-item">${staff.first_name}</a>
        </c:forEach>
    </ul>
</tg:base>

