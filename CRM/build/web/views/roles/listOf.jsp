<%-- 
    Document   : listOf1
    Created on : Jun 8, 2023, 6:44:13 PM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Roles</title>
    </head>

    <body>
        <%--<c:choose>--%>
            <%--<c:when test="${Account.role_name.equals('ROLE_MANAGER')}">--%>
                <!-- Preloader -->
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Roles</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/roles/create.do"/>" class="btn btn-sm btn-success">Add a new role</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table" id="example">

                                        <thead>
                                            <tr>
                                                <th>Roles ID</th>
                                                <th>Roles Name</th>
                                                <th>Description</th>
                                                <th>Operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="roles" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${roles.id}</td>
                                                    <td>${roles.name}</td>
                                                    <td>${roles.description}</td>
                                                    <td>
                                                        <c:if test="${Account.role_name.equals('ROLE_MANAGER')}"> 
                                                            <a href="<c:url value="/roles/update.do?id=${roles.id}" />" class="btn btn-sm btn-primary">Sửa</a>
                                                            <a href="<c:url value="/roles/delete.do?id=${roles.id}" />" class="btn btn-sm btn-warning">Xóa</a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--<jsp:forward page="/error/error.do" />--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    </body>

</html>
