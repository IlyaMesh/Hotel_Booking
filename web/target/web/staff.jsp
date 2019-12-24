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
        <c:forEach items="${staff}" var="staff">
            <div class="panel panel-default">
                <table class="table">
                    <tr>
                        <td width="300">${staff.first_name}</td>
                        <td>${staff.job_name}</td>
                        <td width="150"><a href="${pageContext.request.contextPath}/edit?staff_id=${staff.staff_id}">Update</a></td>
                        <td width="150"><a href="${pageContext.request.contextPath}/delete?staff_id=${staff.staff_id}">Delete</a></td>
                    </tr>
<%--            <a href="${pageContext.request.contextPath}/edit?staff_id=${staff.staff_id}" class="btn btn-default list-group-item list-group-item">Update</a>--%>
<%--            <a href="${pageContext.request.contextPath}/delete?staff_id=${staff.staff_id}" class="btn btn-default list-group-item list-group-item">Delete</a>--%>
                </table>
            </div>
        </c:forEach>
    </ul>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/create?hotel_id=${staff[0].hotel_id}">Add</a>
</tg:base>

