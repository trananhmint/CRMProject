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
        <title>Tasks</title>
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
                            <h4 class="page-title">Danh sách công việc</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/tasks/create.do"/>" class="btn btn-sm btn-success">Thêm mới</a>
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
                                                <th>STT</th>
                                                <th>Task Name</th>
                                                <th>Project</th>
                                                <th></th>
                                                <th>Ngày Bắt Đầu</th>
                                                <th>Ngày Kết Thúc</th>
                                                <th>Trạng Thái</th>
                                                <th>Hành Động</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="tasks" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${loop.count}</td>
                                                    <!--<td>${tasks.id}</td>-->
                                                    <td>${tasks.name}</td>
                                                    <td>${tasks.job_name}</td>
                                                    <td>${tasks.user_name}</td>
                                                    <td>${tasks.start_date}</td>
                                                    <td>${tasks.end_date}</td>
                                                    <td>${tasks.status_name}</td>
                                                    <td>
                                                        <a href="<c:url value="/tasks/update.do?id=${tasks.id}"/>" class="btn btn-sm btn-primary">Sửa</a>
                                                        <a href="<c:url value="/tasks/delete.do?id=${tasks.id}"/>" class="btn btn-sm btn-danger">Xóa</a>
                                                        <a href="#" class="btn btn-sm btn-info">Xem</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--<jsp:forward page="/error/error.do" />--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    </body>

</html>
