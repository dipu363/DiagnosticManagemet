<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!-- Bootstrap-wysihtml5 css -->
        <link href="resources/assets/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css" rel="stylesheet" type="text/css"/>
        <!-- Themify icons -->
        <link href="resources/assets/themify-icons/themify-icons.css" rel="stylesheet" type="text/css"/>
        <!-- End Global Mandatory Style
        =====================================================================-->
        <!-- Start Theme Layout Style
        =====================================================================-->
        <!-- Theme style -->
        <link href="resources/assets/dist/css/stylehealth.min.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/jquery.min.js"></script>
        <style type="text/css">

            .form-control:FOCUS
            {
                border: 2px solid #9ccc65;
                border-radius: 5px;
            }

            .panel>.panel-heading {
                color: #558b2f;
                background-color: #aed581;
                border-color: #aed581;
            }
            .panel>.panel-body
            {
                background-color: #f1f8e9;
                border-color: #aed581;
            }
            .list-group-item {
                overflow: hidden;
                margin: 3px;
                border-radius: 3px;
            }
            #removebuttons
            {
                color: #ffffff;
                background-color: #e57373;
            }
            #removebuttons:HOVER {
                color: #ffffff;
                background-color: #e53935;
            }
            #editbuttons{
                color: #ffffff;
                background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);
            }
            #editbuttons:HOVER {
                color: #ffffff;
                background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);
            }
        </style>
        <script src="resources/js/angular.js"></script>
        <script>
            var treport = ${testreportmodelobject};
            var test = ${testmodelobject};
            var ttype =${testtypemodelobject};
            var tpres =${testprescriptionmodelobject};
            var patient =${patientmodelobject};
            var cartproductlist = ${testcart};
            console.log(ttype);
            console.log(test);
            console.log(treport);
            console.log(tpres);
            console.log(patient);
            angular.module('myapp', []).controller('TestprescriptionController',
                    function ($scope) {
                        $scope.Testreport = treport;
                        $scope.Test = test;
                        $scope.Testtype = ttype;
                        $scope.Testpres = tpres;
                        $scope.Patient = patient;
                        $scope.citems = cartproductlist;
                    });
        </script>
    </head>
    <body class="hold-transition sidebar-mini" ng-app="myapp" ng-controller="TestprescriptionController" >
        <!-- Site wrapper -->
        <div class="wrapper">
            <header class="main-header">
                <a href="doctorprofile" class="logo"> <!-- Logo -->
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

                            <!-- user -->
                            <li class="dropdown dropdown-user admin-user">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                                    <div class="user-image">
                                        <img id="paitentimage" class="img-rounded img-fluid"
                                             src="resources/dimage/${sessionScope.docinfo.doctorid}.jpg" height="40px"
                                             width="40px"/>
                                    </div>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="doctorprofile"><i class="fa fa-users"></i> User Profile</a></li>
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
                            <img id="doctorimage" class="img-rounded img-fluid"
                                 src="resources/dimage/${sessionScope.docinfo.doctorid}.jpg" height="40px"
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
                            <a href="doctorprofile"><i class="fa fa-hospital-o"></i><span>Dashboard</span>
                            </a>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-check-square-o"></i><span>Appointments</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pendingappointment">Pending Appointments</a></li>

                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-check-square-o"></i><span>Prescription</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="addprescription">Add Prescription</a></li>
                                <li><a href="prescriptionlist">View Prescription</a></li>
                                
                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-check-square-o"></i><span>Reprot</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">

                                <li><a href="viewtestreportdoc">View Test Report</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-file-text-o"></i><span>Medicine</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="addmedecinetype">Add Medicine Type</a></li>
                                <li><a href="medicinetypelist">Medicine Type list</a></li>
                                <li><a href="addmedecinegroup">Add Medicine Group</a></li>
                                <li><a href="medicinegrouplist">Medicine Group list</a></li>
                                <li><a href="addmedicine">Add Medicine</a></li>
                                <li><a href="medicinelist">Medicine list</a></li>

                            </ul>
                        </li>

                    </ul>
                </div> <!-- /.sidebar -->
            </aside><!-- /.aside -->
            <!-- =============================================== -->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="header-icon">
                        <i class="pe-7s-note2"></i>
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
                        <h1>Test Prescription</h1>
                        <small>Test Prescription list</small>
                        <ol class="breadcrumb hidden-xs">
                            <li><a href="doctorprofile"><i class="pe-7s-home"></i> Home</a></li>
                            <li class="active">Test Pres..</li>
                        </ol>
                    </div>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <!-- Form controls -->
                        <div class="col-sm-12">
                            <div class="panel panel-bd lobidrag">
                                <div class="panel-heading">
                                    <div class="btn-group"> 
                                        <a class="btn btn-primary" href="testprescriptionlist"> <i class="fa fa-list"></i>  Test Prescription List</a>  
                                    </div>
                                </div>
                                <div class="panel-body">

                                    <form:form class="col-sm-6" name="addTestprescriptionObject"
                                               modelAttribute="addTestprescriptionObject1" action="addtesttocart"
                                               method="post">



                                        <div class="form-group">
                                            <label>Test Type</label>
                                            <select class="form-control" ng-model="selectedTesttype" ng-options="x.typename for x in Testtype"></select>
                                        </div>

                                        <form:hidden  class="form-control" value="{{selectedTesttype.typeid}}" path="typeid"></form:hidden>


                                            <div class="form-group">
                                                <label>Test Name</label>
                                                <select class="form-control" ng-model="selectedTest" ng-options="x.testname for x in Test"></select>
                                            </div>

                                        <form:hidden  class="form-control" value="{{selectedTest.testid}}" path="testid"></form:hidden>

                                            <div class="form-group">
                                                <label>Test Cost</label>
                                            <form:input class="form-control"
                                                        readonly="true" type="number" value="{{selectedTest.testcost}}" path="amount" required="true"></form:input>
                                            </div>

                                            <div class="form-group">
                                                <label>Description</label>
                                            <form:textarea class="form-control"
                                                           type="text" path="description" required="true"></form:textarea>
                                            </div>

                                        <c:if test="${check}">
                                            <div class="reset-button">
                                                <form:button id="editbuttons" type="submit" name="Add"
                                                             class="btn">Save</form:button>
                                            </c:if>
                                            <c:if test="${!check}">
                                                <div class="reset-button">
                                                    <form:button id="editbuttons" type="submit" name="Edit"
                                                                 class="btn">Edit</form:button>
                                                </c:if>

                                                <a href="#" class="btn btn-warning">Reset</a>

                                            </div>
                                        </form:form>
                                    </div>
                                </div>

                                <div class="container" style="min-height: 400px;">
                                    <h3 style="text-align: center; color: #689f38"
                                        style=" border-radius: 5px">Selected Test</h3>

                                    <c:if test="${cartsempty}">
                                        <div class="jumbotron container h4 animated fadeInDown delay-05s" id="jumbotrondiv" align="center">
                                            There are No Test selected yet<br>


                                        </div>
                                    </c:if>
                                    <c:if test="${!cartsempty}">
                                        <table class="table table-striped table-responsive animated fadeInDown delay-05s">
                                            <thead>
                                                <tr scope="row">
                                                    <!--                                <th style="width: 10%">Product</th>-->

                                                    <th style="width: 15%">Type Id</th>
                                                    <th style="width: 7%">Test Id</th>
                                                    <th style="width: 7%">Test Cost</th>
                                                    <th style="width: 7%">Description</th>

                                                </tr>
                                            </thead>

                                            <tbody ng-repeat="items in citems">
                                                <tr scope="row" style="margin: 10px">



                                                    <td>{{items.typeid}}</td>
                                                    <td>{{items.testid}}</td>
                                                    <td>{{items.amount}}</td>
                                                    <td>{{items.description}}</td>


                                                    <td><a href="removetestitem?testid={{items.testid}}"
                                                           id="removebtn" class="btn btn-outline-danger"> <span
                                                                class="glyphicon glyphicon-remove"></span> Remove
                                                        </a></td>
                                                </tr>
                                            </tbody>


                                        </table>
                                        <!--                    <div class="pull-right" style="display: inline-block">
                                                                <a href="buyproductpage" type="button" id="continuebutton"
                                                                   class="btn"><span
                                                                        class="glyphicon glyphicon-shopping-cart"></span> Continue shopping</a>
                                                                <a href="billingaddresspage" class="btn" id="checkoutbutton"><span
                                                                        class="glyphicon glyphicon-tasks"></span> Proceed To Order </a>	
                                                            </div>-->
                                    </c:if>
                                    <div class="panel-body">

                                        <form:form class="col-sm-6" name="addTestprescriptionObject"
                                                   modelAttribute="addTestprescriptionObject1" action="addingtestprescription"
                                                   method="post">



                                            <div class="form-group">
                                                <label>Patient Id</label>
                                                <select class="form-control" ng-model="selectedPatient" ng-options="x.fname for x in Patient"></select>
                                            </div>

                                            <form:hidden  class="form-control" value="{{selectedPatient.pid}}" path="pid"></form:hidden>


                                            <c:if test="${check}">
                                                <div class="reset-button">
                                                    <form:button id="editbuttons" type="submit" name="Add"
                                                                 class="btn">Save</form:button>
                                                </c:if>
                                                <c:if test="${!check}">
                                                    <div class="reset-button">
                                                        <form:button id="editbuttons" type="submit" name="Edit"
                                                                     class="btn">Update</form:button>
                                                    </c:if>

                                                    <a href="#" class="btn btn-warning">Reset</a>

                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section> <!-- /.content -->
            </div> <!-- /.content-wrapper -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs"> <b>Version</b> 1.0</div>
                <strong>Copyright &copy; 2018 <a href="#">Sakibul Haque. Contact Number:01738363303</a>.</strong> All rights reserved.
            </footer>
        </div> <!-- ./wrapper -->
        <!-- Start Core Plugins
        =====================================================================-->
        <!-- jQuery -->
        <script src="resources/assets/plugins/jQuery/jquery-1.12.4.min.js" type="text/javascript"></script>
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

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                            $(document).ready(function () {
                                                                var date_input = $('input[name="testdate"]');
                                                                //our date input has the name "date"
                                                                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                                date_input.datepicker({
                                                                    format: 'yyyy/mm/dd',
                                                                    container: container,
                                                                    todayHighlight: true,
                                                                    autoclose: true,
                                                                })
                                                            })
        </script>
        <script>
                    $(document).ready(function () {
                        var date_input = $('input[name="reportdate"]');
                        //our date input has the name "date"
                        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                        date_input.datepicker({
                            format: 'yyyy/mm/dd',
                            container: container,
                            todayHighlight: true,
                            autoclose: true,
                        })
                    })
        </script>
    </body>

</html>
