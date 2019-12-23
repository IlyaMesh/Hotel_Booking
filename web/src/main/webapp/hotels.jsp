<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <h2>Hotels</h2>

    <ul class="list-group">
        <c:forEach items="${hotels}" var="hotel">
            <a href="${pageContext.request.contextPath}/hotel?hotel_id=${hotel.hotel_id}" class="list-group-item list-group-item">${hotel.city}</a>
        </c:forEach>
    </ul>
</tg:base>
