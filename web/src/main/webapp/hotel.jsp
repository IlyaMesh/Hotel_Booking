<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <div class="card" style="background-color: #EBEDEC;">
        <div class="card-body">
            <h3 class="card-title" align="center">${hotel.name}</h3>
            <p class="card-text" align="center">${hotel.country}, ${hotel.city}</p>
            <p class="card-text" align="center">Rating : ${hotel.rating}</p>
            <div style="align-items: center;text-align: center">
                <a href="${pageContext.request.contextPath}/staff?hotel_id=${hotel.hotel_id}" class="btn btn-primary" style="border-color: #A2AAB0; background-color: #A2AAB0;">Staff</a>
                <a href="${pageContext.request.contextPath}/rooms?hotel_id=${hotel.hotel_id}" class="btn btn-primary" style="border-color: #A2AAB0; background-color: #A2AAB0;">Rooms</a>
                <a href="${pageContext.request.contextPath}/hotel" class="btn btn-secondary">Back</a>
            </div>
        </div>
    </div>
</tg:base>
