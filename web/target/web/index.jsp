<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 22.12.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tg:base>


    <ul class="list-group">
        <div style="background-color: #EBEDEC; margin: 10px" class="card">
            <div class="card-body">
                <h2 align="center" style="font-family: Arial; font-weight: bold">All hotel's
                    chains</h2></div>
        </div>
        <c:forEach items="${chains}" var="chain">
            <div class="panel panel-default">
                <table class="table">
                    <tr>
                        <td rowspan="2" width="150"><img
                                src="${pageContext.request.contextPath}/images/${chain.hotel_chain_id}.jpg"
                                width="102" height="93"></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/chains?chain_id=${chain.hotel_chain_id}"
                               class="list-group-item list-group-item"
                               style="background-color: #EBEDEC;">${chain.name}</a></td>
                    </tr>
                    <tr>
                        <td> Country: ${chain.country}</td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </ul>
</tg:base>