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
    <ul class="list-group">
        <div style="background-color: #EBEDEC; margin: 10px" class="card">
            <div class="card-body">
                <h2 align="center" style="font-family: Arial; font-weight: bold">New staff member</h2>
            </div>
        </div>
        <div class="panel panel-default" style="background-color: #EBEDEC; margin: 10px">
        <form method="post">
            <input type="hidden" value="${staff.staff_id}">
            <input type="hidden" value="${staff.hotel_id}">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>First name</label><br>
                    <input class="form-control" name="first_name"
                           value="${staff.first_name}"/><br><br>
                </div>
                <div class="form-group col-md-6">
                    <label>Last name</label><br>
                    <input class="form-control" name="last_name"
                           value="${staff.last_name}"/><br><br>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-7">
                    <label>Job name</label><br>
                    <input class="form-control" name="job_name" value="${staff.job_name}"/><br><br>
                </div>
                <div class="form-group col-md-5">
                    <label>Salary</label>
                    <input class="form-control" name="salary" type="number" min="50"
                           value="${staff.salary}"/><br><br>
                </div>
            </div>
            <div style="align-items: center;text-align: center">
                <button style="border-color: #A2AAB0; background-color: #A2AAB0; margin-bottom: 20px"
                        type="submit" class="btn btn-primary">Edit
                </button>
            </div>
        </form>
        </div>
    </ul>
</tg:base>