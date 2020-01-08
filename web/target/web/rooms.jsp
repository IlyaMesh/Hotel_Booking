<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 23.12.2019
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <ul class="list-group">
        <div style="background-color: #EBEDEC; margin: 10px" class="card">
            <div class="card-body">
                <h2 align="center" style="font-family: Arial; font-weight: bold">Rooms</h2></div>
        </div>
        <c:forEach items="${rooms}" var="room">
        <c:choose>
            <c:when test="${room.isFree}">
                <div style="background-color: #559688; margin: 10px" class="card">
            </c:when>
            <c:otherwise>
                <div style="background-color: #dc5b5b; margin: 10px" class="card">
            </c:otherwise>
        </c:choose>
<%--        <div style="background-color: #EBEDEC; margin: 10px" class="card">--%>
            <div class="card-body">
                <h3 align="center" class="card-title">${room.room_number}</h3>
                    <%--                    <h1>${room.isFree}</h1>--%>
                <h5 align="center" class="card-title">Category : ${room.room_category}</h5>
                <h6 align="center" class="card-title">Price per night : ${room.price_per_night}</h6>
                <h6 align="center" class="card-title">Max persons : ${room.max_persons}</h6>
                    <%--                    <a href="${pageContext.request.contextPath}/room?hotel_id=${room.hotel_id}"--%>
                    <%--                       class="list-group-item list-group-item">${room.room_category}</a></div>--%>
            </div>
        </div>
            </c:forEach>
    </ul>
</tg:base>

