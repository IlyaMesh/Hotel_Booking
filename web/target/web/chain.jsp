<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 23.12.2019
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <ul class="list-group">
    <c:forEach items="${hotels}" var="hotel">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${hotel.country}</h5>
            <p class="card-text">${hotel.name}</p>
<%--            <a href="${pageContext.request.contextPath}/chains" class="btn btn-secondary">Back</a>--%>
            <a href="${pageContext.request.contextPath}/hotel?hotel_id=${hotel.hotel_id}" class="list-group-item list-group-item">${hotel.city}</a>
        </div>
    </div>
    </c:forEach>
</tg:base>
