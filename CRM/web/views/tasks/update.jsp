<%-- 
    Document   : update
    Created on : Jun 14, 2023, 11:13:02 PM
    Author     : Dell
--%>

<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Tasks Update</title>
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
                    <h4 class="page-title">Update Tasks</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/tasks/update_handler.do"/>" class="form-horizontal form-material">
                            <div class="form-group">
                                <label class="col-md-12">Task ID</label>
                                <div class="col-md-12">
                                    <input disabled type="number" placeholder="Tasks ID" value="${tasks.id}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="id" value="${tasks.id}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Task Name</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Task Name" name="name" value="${tasks.name}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Start Date</label>
                                <div class="col-md-12">
                                    <input type="date" placeholder="Start Date" name="start_date" value="${tasks.start_date}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">End Date</label>
                                <div class="col-md-12">
                                    <input type="date" placeholder="End Date" name="end_date" value="${tasks.end_date}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">User ID</label>
                                <div class="col-md-12">
                                    <input type="number" placeholder="User ID" name="user_id" value="${tasks.user_id}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Job ID</label>
                                <div class="col-md-12">
                                    <input type="number" placeholder="Job ID" name="job_id" value="${tasks.job_id}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>
                                           
                            <div class="form-group">
                                <label class="col-md-12">Status ID</label>
                                <div class="col-md-12">
                                    <input type="number" placeholder="Status ID" name="status_id" value="${tasks.status_id}"
                                           class="form-control form-control-line" />
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