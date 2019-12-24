<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 24.12.2019
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
<h3>New staff member</h3>
<form method="post">
    <input type="hidden" value="${staff.staff_id}">
    <input type="hidden" value="${staff.hotel_id}">
    <label>First name</label><br>
    <input name="first_name" value="${staff.first_name}"/><br><br>
    <label>Last name</label><br>
    <input name="last_name" value="${staff.last_name}"/><br><br>
    <label>Job name</label><br>
    <input name="job_name" value="${staff.job_name}"/><br><br>
    <label>Salary</label>
    <input name="salary" type="number" min="50" value="${staff.salary}"/><br><br>
    <input type="submit" value="Save"/>
</form>
</tg:base>