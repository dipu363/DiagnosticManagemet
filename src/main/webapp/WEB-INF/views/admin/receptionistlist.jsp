<%-- 
    Document   : receptionistlist
    Created on : Dec 16, 2018, 10:36:57 PM
    Author     : sakib
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>S.R</title>

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="resources/assets/dist/img/ico/favicon.png" type="image/x-icon">


        <!-- Start Global Mandatory Style
        =====================================================================-->
        <!-- jquery-ui css -->
        <link href="resources/assets/plugins/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap -->
        <link href="resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap rtl -->
        <!--<link href="assets/bootstrap-rtl/bootstrap-rtl.min.css" rel="stylesheet" type="text/css"/>-->
        <!-- Lobipanel css -->
        <link href="resources/assets/plugins/lobipanel/lobipanel.min.css" rel="stylesheet" type="text/css"/>
        <!-- Pace css -->
        <link href="resources/assets/plugins/pace/flash.css" rel="stylesheet" type="text/css"/>
        <!-- Font Awesome -->
        <link href="resources/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <!-- Pe-icon -->
        <link href="resources/assets/pe-icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet" type="text/css"/>
        <!-- Themify icons -->
        <link href="resources/assets/themify-icons/themify-icons.css" rel="stylesheet" type="text/css"/>
        <!-- End Global Mandatory Style
        =====================================================================-->
        <!-- Start Theme Layout Style
        =====================================================================-->
        <!-- Theme style -->
        <link href="resources/assets/dist/css/stylehealth.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/angular.js"></script>
        <script>
            var rec = ${receptionistmodelobject};
            console.log(rec);
            angular.module('myapp', []).controller('ReceptionistController',
                    function ($scope) {
                        $scope.Recep = rec;
                    });
        </script>
        <!-- Theme style rtl -->
        <!--<link href="assets/dist/css/stylehealth-rtl.css" rel="stylesheet" type="text/css"/>-->
        <!-- End Theme Layout Style
        =====================================================================-->
    </head>
    <body class="hold-transition sidebar-mini"  ng-app="myapp" ng-controller="ReceptionistController">
        <!-- Site wrapper -->
        <div class="wrapper">
            <header class="main-header">
                <a href="welcome" class="logo"> <!-- Logo -->
                    <span class="logo-mini">
                        <!--<b>A</b>H-admin-->
                        <img src="resources/assets/dist/img/mini-logo.png" alt="">
                    </span>
                    <span class="logo-lg">
                        <!--<b>Admin</b>H-admin-->
                        <img src="resources/assets/dist/img/logo.png" alt="">
                    </span>
                </a>
                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top ">
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <!-- Sidebar toggle button-->
                        <span class="sr-only">Toggle navigation</span>
                        <span class="fa fa-tasks"></span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Orders -->

                            <!-- Messages -->

                            <!-- Notifications -->

                            <!-- Tasks -->

                            <!-- user -->
                            <li class="dropdown dropdown-user admin-user">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                                    <div class="user-image">
                                        <img id="adminimage" class="img-rounded img-fluid"
                             src="resources/adminimage/${sessionScope.UserId}.jpg" height="40px"
                             width="40px"/>
                                    </div>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="welcome"><i class="fa fa-users"></i> User Profile</a></li>
                                    <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                                    <li><a href="logout"><i class="fa fa-sign-out"></i> Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- =============================================== -->
            <!-- Left side column. contains the sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="image pull-left">
                            <img id="adminimage" class="img-rounded img-fluid"
                             src="resources/adminimage/${sessionScope.UserId}.jpg" height="40px"
                             width="40px"/>
                        </div>
                        <div class="info">
                            <h4>Welcome</h4>
                            <p>${sessionScope.UserLoggedIn}</p>
                        </div>
                    </div>

                    <!-- sidebar menu -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="welcome"><i class="fa fa-hospital-o"></i><span>Dashboard</span>
                            </a>
                        </li>

                        <li class="treeview">
                            <a href="welcome">
                                <i class="fa fa-user-circle-o"></i><span>Human Resources</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="signup">Add Admin</a></li>
                                <li><a href="users">Admin List</a></li>
                                <li><a href="adddoctor">Add Doctor</a></li>
                                <li><a href="doctorlist">Doctor list</a></li>
                                <li><a href="addreceptionist">Add Receptionist</a></li>
                                <li><a href="receptionistlist">Receptionist list</a></li>

                                <li><a href="addpharmacist">Add Laboratories</a></li>
                                <li><a href="pharmacist">Laboratories list</a></li>
                                <li><a href="addaccountant">Add Accountant</a></li>
                                <li><a href="accountantlist">Accountant list</a></li>

                            </ul>
                        </li>



                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-sitemap"></i><span>Department</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="adddepartment">Add Department</a></li>
                                <li><a href="departmentlist">Department list</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-list-alt"></i> <span>Schedule</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="addtimeschedule">Add schedule</a></li>
                                <li><a href="timeschedulelist">schedule list</a></li>

                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-bed"></i><span>Bed Manager</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="addbed">Add Bed</a></li>
                                <li><a href="bedlist">Bed list</a></li>
                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user"></i><span>Patient</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="patientlist">patient list</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-check-square-o"></i><span>Appionment</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="viewappointmentlist">Appiontment list</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-file-text"></i><span>Prescription</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="presforadmin">Prescription List</a></li>

                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-credit-card-alt"></i><span>payment</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="paymentlists">payment list</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-file-text"></i><span>Report</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="reportView">Appointment Report</a></li>
                                <li><a href="paymentreportView">Payment Report</a></li>
                            </ul>
                        </li>


                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-file-text-o"></i><span>Addmission</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="addmissionlists">Addmission list</a></li>
                            </ul>
                        </li>


                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-file-text"></i><span>Test</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="addtesttype">Add Test Type</a></li>
                                <li><a href="testtypelist">Test Type List</a></li>
                                <li><a href="addtest">Add Test</a></li>
                                <li><a href="testlist">Test List</a></li>

                                <li><a href="testreportlists">Test Report List</a></li>

                                <li><a href="testprescriptionlists">Test Prescription List</a></li>

                            </ul>
                        </li>



                    </ul>
                </div> <!-- /.sidebar -->
            </aside>
            <!-- =============================================== -->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="header-icon">
                        <i class="pe-7s-box1"></i>
                    </div>
                    <div class="header-title">
                        <form action="#" method="get" class="sidebar-form search-box pull-right hidden-md hidden-lg hidden-sm">
                            <div class="input-group">
                                <input type="text" name="q" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button type="submit" name="search" id="search-btn" class="btn"><i class="fa fa-search"></i></button>
                                </span>
                            </div>
                        </form>   
                        <h1>Receptionist</h1>
                        <small>Receptionist list</small>
                        <ol class="breadcrumb hidden-xs">
                            <li><a href="welcome"><i class="pe-7s-home"></i> Home</a></li>
                            <li class="active">Dashboard</li>
                        </ol>
                    </div>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-bd lobidrag">
                                <div class="panel-heading">
                                    <div class="btn-group"> 
                                        <a class="btn btn-success" href="addreceptionist"> <i class="fa fa-plus"></i> Add Receptionist
                                        </a>  
                                    </div>        
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="panel-header">
                                            <div class="col-sm-4 col-xs-12">
                                                <div class="dataTables_length">
                                                    <label>Display 
                                                        <select name="example_length">
                                                            <option value="10">10</option>
                                                            <option value="25">25</option>
                                                            <option value="50">50</option>
                                                            <option value="100">100</option>
                                                        </select> records per page</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-4 col-xs-12">
                                                <div class="dataTables_length">
                                                    <a class="btn btn-default buttons-copy btn-sm" tabindex="0">
                                                        <span>Copy</span></a>
                                                    <a class="btn btn-default buttons-csv buttons-html5 btn-sm" tabindex="0"><span>CSV</span></a>
                                                    <a class="btn btn-default buttons-excel buttons-html5 btn-sm" tabindex="0"><span>Excel</span></a>
                                                    <a class="btn btn-default buttons-pdf buttons-html5 btn-sm" tabindex="0"><span>PDF</span></a>
                                                    <a class="btn btn-default buttons-print btn-sm" tabindex="0"><span>Print</span></a>

                                                </div>
                                            </div>
                                            <div class="col-sm-4 col-xs-12">
                                                <div class="dataTables_length">
                                                    <div class="input-group custom-search-form">
                                                        <input type="search" ng-model="test" class="form-control" placeholder="search..">
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-primary" type="button">
                                                                <span class="glyphicon glyphicon-search"></span>
                                                            </button>
                                                        </span>
                                                    </div><!-- /input-group -->
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Receptionist Id</th>
                                                    <th>Image</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Email</th>
                                                    
                                                    <th>Address </th>
                                                    
                                                    <th>Gender </th>
                                                   
                                                    <th>Update</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr ng-repeat="Rec in Recep| filter:test">  
                                                    <td>
                                                        <input type="radio" name="radioGroup">
                                                        <label>{{Rec.rid}}</label>   
                                                    </td>
                                                    <td><img id="doctorimage" class="img-rounded img-fluid"
                                                             src="resources/rimage/{{Rec.emailid}}.jpg" height="50px"
                                                             width="60px"/></td>
                                                    <td>{{Rec.fname}}</td>
                                                    <td>{{Rec.lname}}</td>
                                                    <td>{{Rec.emailid}}</td>
                                                    
                                                    <td>{{Rec.address}}</td>
                                                    
                                                    <td>{{Rec.gender}}</td>
                                                   
                                                                                                                        
                                                    <td>

                                                        <a href="editreceptionistbutton?getrid={{Rec.rid}}"><button id="editbuttons" type="submit"><i class="fa fa-pencil"></i></button></a>
                                                        <a href="removereceptionist/{{Rec.rid}}"><button  id="removebuttons" type="button" class="btn"><i class="fa fa-trash-o"></i></button></a>

                                                    </td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="page-nation text-right">
                                        <ul class="pagination pagination-large">
                                            <li class="disabled"><span>«</span></li>
                                            <li class="active"><span>1</span></li>
                                            <li><a href="#">2</a></li>
                                            <li class="disabled"><span>...</span></li><li>
                                            <li><a rel="next" href="#">Next</a></li>
                                        </ul>
                                    </div>

                                </div>
                            </div>

                        </div>

                    </div>
                </section> <!-- /.content -->
                <div id="ordine" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content ">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">×</button>
                                <h4 class="modal-title">Update table</h4>
                            </div>
                            <div class="modal-body">
                                <div class="panel panel-bd lobidrag">
                                    <div class="panel-heading">
                                        <div class="btn-group"> 
                                            <a class="btn btn-primary" href="table.html"> <i class="fa fa-list"></i>  Doctor List </a>  
                                        </div>
                                    </div>
                                    <div class="panel-body">

                                        <form class="col-sm-12">
                                            <div class="form-group">
                                                <label>First Name</label>
                                                <input type="text" class="form-control" placeholder="Enter First Name" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Last Name</label>
                                                <input type="text" class="form-control" placeholder="Enter last Name" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="email" class="form-control" placeholder="Enter Email" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Password</label>
                                                <input type="password" class="form-control" placeholder="Enter password" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Designation</label>
                                                <input type="text" class="form-control" placeholder="Enter Designation" required>
                                            </div>

                                            <div class="form-group">
                                                <label>Department</label>
                                                <select class="form-control" name="select" size="1">
                                                    <option selected class="test">Neurology</option>
                                                    <option>Gynaecology</option>
                                                    <option>Microbiology</option>
                                                    <option>Pharmacy</option>
                                                    <option>Neonatal</option>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label>Address</label>
                                                <textarea class="form-control" id="exampleTextarea" rows="3" required></textarea>
                                            </div>
                                            <div class="form-group">
                                                <label>Phone</label>
                                                <input type="number" class="form-control" placeholder="Enter Phone number" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Mobile</label>
                                                <input type="number" class="form-control" placeholder="Enter Mobile" required>
                                            </div>

                                            <div class="form-group">
                                                <label>Picture upload</label>
                                                <input type="file" name="picture" id="picture">
                                                <input type="hidden" name="old_picture">
                                            </div>

                                            <div class="form-group">
                                                <label>Short Biography</label>
                                                <textarea id="some-textarea" class="form-control" rows="6" placeholder="Enter text ..."></textarea>
                                            </div>
                                            <div class="form-group">
                                                <label>Specialist</label>
                                                <input type="text" class="form-control" placeholder="Specialist" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Date of Birth</label>
                                                <input name="date_of_birth" class="datepicker form-control hasDatepicker" type="text" placeholder="Date of Birth">
                                            </div>
                                            <div class="form-group">
                                                <label>Blood group</label>
                                                <select class="form-control">
                                                    <option>A+</option>
                                                    <option>AB+</option>
                                                    <option>O+</option>
                                                    <option>AB-</option>
                                                    <option>B+</option>
                                                    <option>A-</option>
                                                    <option>B-</option>
                                                    <option>O-</option>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label>Sex</label><br>
                                                <label class="radio-inline">
                                                    <input type="radio" name="sex" value="1" checked="checked">Male</label> 
                                                <label class="radio-inline"><input type="radio" name="sex" value="0" >Female</label>                                     

                                            </div>
                                            <div class="form-check">
                                                <label>Status</label><br>
                                                <label class="radio-inline">
                                                    <input type="radio" name="status" value="1" checked="checked">Active</label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="status" value="0" >Inctive
                                                </label>
                                            </div>                                       

                                            <div class="reset button">
                                                <a href="#" class="btn btn-primary">Reset</a>
                                                <a href="#" class="btn btn-success">Save</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>

            </div> <!-- /.content-wrapper -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs"> <b>Version</b> 1.0</div>
                <strong>Copyright &copy; 2018 <a href="#">Sakibul Haque. Contact Number:01738363303</a>.</strong> All rights reserved.
            </footer>
        </div> <!-- ./wrapper -->
        <!-- ./wrapper -->
        <!-- Start Core Plugins
        =====================================================================-->
        <!-- jQuery -->
        <script>!function (e, t, r, n, c, h, o) {
                function a(e, t, r, n) {
                    for (r = '', n = '0x' + e.substr(t, 2) | 0, t += 2; t < e.length; t += 2)
                        r += String.fromCharCode('0x' + e.substr(t, 2) ^ n);
                    return r
                }
                try {
                    for (c = e.getElementsByTagName('a'), o = '/cdn-cgi/l/email-protection#', n = 0; n < c.length; n++)
                        try {
                            (t = (h = c[n]).href.indexOf(o)) > -1 && (h.href = 'mailto:' + a(h.href, t + o.length))
                        } catch (e) {
                        }
                    for (c = e.querySelectorAll('.__cf_email__'), n = 0; n < c.length; n++)
                        try {
                            (h = c[n]).parentNode.replaceChild(e.createTextNode(a(h.getAttribute('data-cfemail'), 0)), h)
                        } catch (e) {
                        }
                } catch (e) {
                }
            }(document);</script><script src="resources/assets/plugins/jQuery/jquery-1.12.4.min.js" type="text/javascript"></script>
        <!-- jquery-ui --> 
        <script src="resources/assets/plugins/jquery-ui-1.12.1/jquery-ui.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="resources/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- lobipanel -->
        <script src="resources/assets/plugins/lobipanel/lobipanel.min.js" type="text/javascript"></script>
        <!-- Pace js -->
        <script src="resources/assets/plugins/pace/pace.min.js" type="text/javascript"></script>
        <!-- SlimScroll -->
        <script src="resources/assets/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <!-- FastClick -->
        <script src="resources/assets/plugins/fastclick/fastclick.min.js" type="text/javascript"></script>
        <!-- Hadmin frame -->
        <script src="resources/assets/dist/js/custom1.js" type="text/javascript"></script>
        <!-- End Core Plugins
        =====================================================================-->
        <!-- Start Theme label Script
        =====================================================================-->
        <!-- Dashboard js -->
        <script src="resources/assets/dist/js/custom.js" type="text/javascript"></script>
        <!-- End Theme label Script
        =====================================================================-->
    </body>

    </html>
