<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 23.12.2019
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<tg:base>
    <h3>New staff member</h3>
    <form method="post">
        <div class="form-group">
            <label>First name</label><br>
            <input name="first_name"/><br><br>
            <label>Last name</label><br>
            <input name="last_name"/><br><br>
            <label>Job name</label><br>
            <input name="job_name"/><br><br>
            <label>Salary</label>
            <input name="salary" type="number" min="50"/><br><br>
        </div>
        <input type="submit" value="Save"/>
    </form>
    </body>
    </html>
</tg:base>