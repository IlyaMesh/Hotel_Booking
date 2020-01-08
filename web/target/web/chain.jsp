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
    <div style="background-color: #EBEDEC; margin: 10px" class="card">
        <div class="card-body">
            <h2 align="center" style="font-family: Arial; font-weight: bold">Hotels</h2>
        </div>
    </div>

    <c:forEach items="${hotels}" var="hotel">
        <div style="background-color: #EBEDEC; margin: 10px" class="card">
            <div class="card-body">
                <h3 align="center" class="card-title">${hotel.name}</h3>
                <h5 align="center" class="card-title">${hotel.country}, ${hotel.city}</h5>
                    <%--            <a href="${pageContext.request.contextPath}/chains" class="btn btn-secondary">Back</a>--%>
                <a href="${pageContext.request.contextPath}/hotel?hotel_id=${hotel.hotel_id}"
                   class="list-group-item list-group-item"
                   style="text-align: center;background-color: #EBEDEC;">Show more</a>
            </div>
        </div>
    </c:forEach>
</tg:base>
