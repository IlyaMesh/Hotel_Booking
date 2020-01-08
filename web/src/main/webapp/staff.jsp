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

    <ul class="list-group">
        <div style="background-color: #EBEDEC; margin: 10px" class="card">
            <div class="card-body">
                <h2 align="center" style="font-family: Arial; font-weight: bold">Staff</h2></div>
        </div>
        <div class="panel panel-default" style="background-color: #EBEDEC; margin: 10px">
            <table class="table">
                <tr>
                    <td style="font-weight: bold">First name</td>
                    <td style="font-weight: bold">Last name</td>
                    <td style="font-weight: bold">Job name</td>
                    <td style="font-weight: bold">Salary</td>
                    <td style="font-weight: bold">Update</td>
                    <td style="font-weight: bold">Delete</td>
                </tr>
                <c:forEach items="${staff}" var="staff">


                <tr>
                    <td width="150">${staff.first_name}</td>
                    <td width="200">${staff.last_name}</td>
                    <td>${staff.job_name}</td>
                    <td>${staff.salary}</td>
                    <td width="150"><a class="btn btn-primary" style="border-color: #A2AAB0; background-color: #A2AAB0;"
                            href="${pageContext.request.contextPath}/edit?staff_id=${staff.staff_id}">Update</a>
                    </td>
                    <td width="150"><a class="btn btn-primary" style="border-color: #3D3D3B; background-color: #3D3D3B;"
                            href="${pageContext.request.contextPath}/delete?staff_id=${staff.staff_id}">Delete</a>
                    </td>
                </tr>
                    <%--            <a href="${pageContext.request.contextPath}/edit?staff_id=${staff.staff_id}" class="btn btn-default list-group-item list-group-item">Update</a>--%>
                    <%--            <a href="${pageContext.request.contextPath}/delete?staff_id=${staff.staff_id}" class="btn btn-default list-group-item list-group-item">Delete</a>--%>
                </c:forEach>
            </table>
        </div>

    </ul>
    <div style="align-items: center;text-align: center">
        <a class="btn btn-primary" style="border-color: #4C5870; background-color: #4C5870; margin-bottom: 20px"
           href="${pageContext.request.contextPath}/create?hotel_id=${staff[0].hotel_id}">Add</a>
    </div>
</tg:base>

