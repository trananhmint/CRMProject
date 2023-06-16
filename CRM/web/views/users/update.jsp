<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User Update</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Update user</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/users/update_handler.do"/>" class="form-horizontal form-material">
                            
                              <div class="form-group">
                                <label class="col-md-12">User ID</label>
                                <div class="col-md-12">
                                    <input disabled type="number" placeholder="User ID" value="${users.id}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="id" value="${users.id}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Email</label>
                                <div class="col-md-12">
                                    <input type="email" placeholder="Email" name="email" value="${users.email}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Password</label>
                                <div class="col-md-12">
                                    <input  disabled type="password" placeholder="Password"  value="${users.password}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="password" value="${users.password}">
                                </div>
                            </div>         
                            <div class="form-group">
                                <label class="col-md-12">Full Name</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Full Name" name="fullname" value="${users.fullname}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12"> Avatar </label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Avatar" name="avatar" value="${users.avatar}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Status</label>
                                <div class="col-md-12">
                                    <input type="number" placeholder="Status" name="status" value="${users.status}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Role</label>
                                <div class="col-md-12">
                                    <select name="role_id"class="form-control form-control-line">
                                        <option value="1">ROLE_ADMIN</option>
                                        <option value="2">ROLE_MANAGER</option>
                                        <option value="3">ROLE_USER</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">

                                    <button type="submit" class="btn btn-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
                                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel<i class="bi bi-x-square"></i></button>

                                </div>
                            </div>
                        </form>

                    </div>
                </div>
                <div class="col-md-2 col-12"></div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

        <!-- /#page-wrapper -->

    </body>

</html>