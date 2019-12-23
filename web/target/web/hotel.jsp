<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${hotel.name}</h5>
            <p class="card-text">${hotel.country}</p>
            <p class="card-text">${hotel.city}</p>
            <p class="card-text">${hotel.rating}</p>
            <a href="${pageContext.request.contextPath}/hotel" class="btn btn-secondary">Back</a>
            <a href="" class="btn btn-default">Staff</a>
            <a href="" class="btn btn-default">Rooms</a>
        </div>
    </div>
</tg:base>