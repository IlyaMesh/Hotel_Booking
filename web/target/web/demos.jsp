<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <h2>Main Servlet jsp</h2>

    <ul class="list-group">
        <c:forEach items="${demos}" var="demo">
            <a href="${pageContext.request.contextPath}/demo?idx=${demo.hotel_id}" class="list-group-item list-group-item">${demo.adress}</a>
        </c:forEach>
    </ul>
</tg:base>
