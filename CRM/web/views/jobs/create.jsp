<%-- 
    Document   : create
    Created on : Jun 14, 2023, 11:50:11 PM
    Author     : Dell
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
        <title>Pixel Admin</title>
        <!-- Bootstrap Core CSS -->
        <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Menu CSS -->
        <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
        <!-- animation CSS -->
        <link href="css/animate.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/style.css" rel="stylesheet">
        <!-- color CSS -->
        <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
       

                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material" action="<c:url value="/jobs/create_handler.do"/>">
                                <div class="form-group">
                                    <label class="col-md-12">Project Name</label>
                                    <div class="col-md-12">
                                        <input type="text" name="name" placeholder="Tên công việc"
                                               class="form-control form-control-line" value="${jobs.name}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Date Start</label>
                                    <div class="col-md-12">
                                        <input type="date" name="start_date" placeholder="yyyy-MM-dd"
                                               class="form-control form-control-line" value="${jobs.start_date}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Date End</label>
                                    <div class="col-md-12">
                                        <input type="date" name="end_date" placeholder="yyyy-MM-dd"
                                               class="form-control form-control-line" value="${jobs.end_date}> </div>
                                               </div>
                                               <div class="form-group">
                                               <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success" name="op" value="create">Create</button>
                                            <a href="groupwork.html" class="btn btn-primary" name="op" value="cancel" >Cancel</a>
                                        </div>
                                    </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>

</body>
</html> 

