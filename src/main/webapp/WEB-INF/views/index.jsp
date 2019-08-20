<%-- 
    Document   : index
    Created on : Nov 19, 2018, 5:17:06 PM
    Author     : User
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Site Title -->
        <title>S.R</title>
        <!-- Meta Description Tag -->
        <meta name="Description" content="Klinik is a HTML5 & CSS3 responsive template">
        <!-- Favicon Icon -->
        <link rel="icon" type="image/x-icon" href="resources/resource/images/favicon.png" />
        <!-- Font Awesoeme Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/font-awesome/css/font-awesome.min.css" />
        <!-- Google web Font -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="resources/resource/css/bootstrap.min.css">
        <!-- Material Design Lite Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/material.min.css" />
        <!-- Material Design Select Field Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/mdl-selectfield.min.css">
        <!-- Owl Carousel Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/owl.carousel.min.css" />
        <!-- Animate Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/animate.min.css" />
        <!-- Magnific Popup Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/magnific-popup.css" />
        <!-- Flex Slider Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/flexslider.css" />
        <!-- Custom Main Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/css/style.css">

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
            var doctor = ${doctormodelobject};
            console.log(doctor);
            angular.module('myapp', []).controller('DoctorController',
                    function ($scope) {
                        $scope.Doctor = doctor;
                    });
        </script>
    </head>
    <body ng-app="myapp" ng-controller="DoctorController">
        <!-- Start Header Section -->
        <header id="header-transparent">
            <div class="layer-stretch hdr-center">
                <div class="row align-items-center">
                    <div class="col-5 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                        <div class="hdr-center-account text-left p-0">
                            <a href="login" class="font-14 mr-4"><i class="fa fa-sign-in"></i>Login</a>
                            <a href="patientsignup" class="font-14"><i class="fa fa-user-o"></i>Register</a>
                        </div>
                    </div>
                    <div class="col">
                        <div class="hdr-center-logo text-center">
                            <a href="index" class="d-inline-block"><img src="resources/images/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-5 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                        <div class="pull-right">
                            <ul class="social-list social-list-white">
                                <li>
                                    <a href="#" id="hdr-facebook" class="fa fa-facebook rounded"></a>
                                    <span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-facebook">Facebook</span>
                                </li>
                                <li>
                                    <a href="#" id="hdr-twitter" class="fa fa-twitter rounded"></a>
                                    <span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-twitter">Twitter</span>
                                </li>
                                <li>
                                    <a href="#" id="hdr-google" class="fa fa-google rounded"></a>
                                    <span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-google">Google</span>
                                </li>
                                <li>
                                    <a href="#" id="hdr-instagram" class="fa fa-instagram rounded"></a>
                                    <span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-instagram">Instagram</span>
                                </li>
                                <li>
                                    <a href="#" id="hdr-youtube" class="fa fa-youtube rounded"></a>
                                    <span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-youtube">Youtube</span>
                                </li>
                                <li>
                                    <a href="#" id="hdr-linkedin" class="fa fa-linkedin rounded"></a>
                                    <span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-linkedin">Linkedin</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-transparent-menu">
                <div class="hdr layer-stretch">
                    <div class="row align-items-center justify-content-end">
                        <!-- Start Menu Section -->
                        <ul class="col menu text-left">
                            <li>
                                <a href="index" id="menu-home" class="mdl-button mdl-js-button mdl-js-ripple-effect">Home <i class="fa fa-chevron-down"></i></a>

                            </li>
                            <li>
                                <a href="showdoctorlist" id="menu-pages" class="mdl-button mdl-js-button mdl-js-ripple-effect">Doctors <i class="fa fa-chevron-down"></i></a>

                            </li>



                            <li>
                                <a id="menu-profile" class="mdl-button mdl-js-button mdl-js-ripple-effect">Profile <i class="fa fa-chevron-down"></i></a>
                                <ul class="menu-dropdown">
                                    <li><a href="login">Login Page</a></li>

                                    <li><a href="patientsignup">Register Page</a></li>


                                </ul>
                            </li>

                            <li>
                            </li>
                            <li class="mobile-menu-close"><i class="fa fa-times"></i></li>
                        </ul><!-- End Menu Section -->
                        <div class="col col-md-auto d-none d-sm-block d-md-block d-lg-block d-xl-block">
                            <a href="showdoctorlist"><button class="mdl-button mdl-button--colored mdl-button--raised mdl-js-button mdl-js-ripple-effect hdr-apointment"><i class="fa fa-calendar m-0 color-white"></i> Make An Appointment</button></a>
                        </div>
                        <div class="col-2 col-md-auto col-lg-auto">
                            <div class="mdl-button mdl-js-button mdl-button--fab hdr-search">
                                <i class="fa fa-search fa-2x color-white"></i>
                            </div>
                        </div>
                        <div id="menu-bar" class="col-2 col-md-auto"><a><i class="fa fa-bars color-white"></i></a></div>
                    </div>
                    <div class="search-banner animated fadeInUp">
                        <form:form  name="addDoctorObject" modelAttribute="addDoctorObject1" action="searchdoctor" method="post" enctype="multipart/form-data">
                            <form:input type="text" path="deptname" placeholder="Search your Doctor By Department ..."/>
                        </form:form>
                    </div>
                </div>
            </div>
        </header><!-- End Header Section -->
        <!-- Start Slider Section -->
        <div id="slider" class="slider-1 slider-2">
            <div class="flexslider slider-wrapper">
                <ul class="slides">     
                    <li>
                        <div class="slider-info">
                            <h1 class="animated fadeInDown">Avoid food and drink</h1>
                            <p class="animated fadeInDown">It is important that you don’t eat or drink before being seen. You may need tests or procedures that require you not to eat or drink beforehand. Speak to the triage nurse if you have any questions about this.</p>
                        </div>
                        <div class="slider-backgroung-image" style="background-image: url(resources/uploads/slider-1.jpg);"></div>
                        <!-- Make an Appointment  Button -->

                        <div class="slider-button slider-appointment">
                            <a href="showdoctorlist"  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect  animated fadeInUp">Make An Appointment<i class="fa fa-flag-checkered"></i></a>
                        </div>
                    </li>
                    <li>
                        <div class="slider-info">
                            <h2>Your Identity. Our Responsibility</h2>
                            <p>A staff member will take you to a treatment area where you will be re-assessed, examined and your problem will be discussed with you. The treating clinician will tell you about any tests or treatments that may be required. Feel free to ask questions about your condition and your treatment at any time. </p>
                        </div>
                        <div class="slider-backgroung-image" style="background-image: url(resources/uploads/slider-2.jpg);"></div>
                        <!-- Make an Appointment  Button -->
                        <div class="slider-button">
                            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect  animated fadeInUp">Read More<i class="fa fa-external-link"></i></a>
                        </div>
                    </li>
                    <li>
                        <div class="slider-info">
                            <h2>24/7 Support Services</h2>
                            <p>Do not hesitate to contact us on our dedicated support forum. mollitia maiores temp fugit! Lorem ipsum dolor sit amet, consectetur adipisicing elit #twitterhash, @facebooktag</p>
                        </div>
                        <div class="slider-backgroung-image" style="background-image: url(resources/uploads/slider-3.jpg);"></div>
                        <!-- Make an Appointment  Button -->
                        <div class="slider-button">
                            <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect  animated fadeInUp">About Us<i class="fa fa-eye"></i></a>
                        </div>
                    </li>
                </ul>
            </div>
        </div><!-- End Slider Section -->
        <!-- Start Service Section -->
        <div id="hm-service" class="layer-stretch">
            <div class="layer-wrapper">
                <div class="layer-ttl">
                    <h3>What We Do</h3>
                </div>
                <div class="layer-container row">
                    <div class="hm-service-left col-md-5">
                        <img src="resources/uploads/hm-service.jpg" alt="Klinical Health care">
                    </div>
                    <div class="hm-service-right col-md-7">
                        <p class="paragraph-medium paragraph-black">Your emergency care starts as soon as you arrive at the emergency department. A specialist emergency nurse, called the triage nurse, will assess your condition, provide first aid and prioritise you for treatment. You may be asked to wait in the waiting room. How long you wait depends on how busy the department is at the time and the number of patients with conditions more serious than yours.

                            Sometimes the waiting area appears quiet, but this doesn’t mean the emergency department is not busy.

                            Staff members understand that waiting can be frustrating. They do their best to keep your wait to a minimum and make you comfortable. If your condition changes while you are waiting, let the triage nurse know.</p>
                        <div class="hm-service">
                            <div class="hm-service-block">
                                <i class="fa fa-stethoscope"></i>
                                <span>Cardiovascular centre</span>
                            </div>
                            <div class="hm-service-block">
                                <i class="fa fa-child"></i>
                                <span>Childbirth Center</span>
                            </div>
                            <div class="hm-service-block">
                                <i class="fa fa-certificate"></i>
                                <span>Mammography</span>
                            </div>
                            <div class="hm-service-block">
                                <i class="fa fa-h-square"></i>
                                <span>Dermatologist</span>
                            </div>
                            <div class="hm-service-block">
                                <i class="fa fa-stethoscope"></i>
                                <span>Paediatrics</span>
                            </div>
                            <div class="hm-service-block">
                                <i class="fa fa-bullhorn"></i>
                                <span>Radiology Center</span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div><!-- End Service Section -->
        <!-- Start About Section -->
        <div id="hm-about" class="parallax-background parallax-background-1">
            <div class="layer-stretch">
                <div class="layer-wrapper">
                    <div class="layer-ttl layer-ttl-white">
                        <h3>Who We Are</h3>
                    </div>
                    <div class="row">
                        <div class="col-md-7">
                            <div class="hm-about-block">
                                <div class="tbl-cell hm-about-icon"><i class="fa fa-user-md"></i></div>
                                <div class="tbl-cell hm-about-number">
                                    <span class="counter">${totaldoc}</span>
                                    <p>Doctor(s)</p>
                                </div>
                            </div>
                            <div class="hm-about-block">
                                <div class="tbl-cell hm-about-icon"><i class="fa fa-ambulance"></i></div>
                                <div class="tbl-cell hm-about-number">
                                    <span class="counter">${totalroom}</span>
                                    <p>Room(s)</p>
                                </div>
                            </div>

                            <div class="hm-about-block">
                                <div class="tbl-cell hm-about-icon"><i class="fa fa-clock-o"></i></div>
                                <div class="tbl-cell hm-about-number">
                                    <span class="counter">168</span>
                                    <p>Opening Hours per Week</p>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div><!-- End About Section -->

       

        <!-- Start Emergency Section -->
        <div id="emergency">
            <div class="layer-stretch">
                <div class="layer-wrapper">
                    <div class="layer-ttl">
                        <h3>On Emergency</h3>
                    </div>
                    <div class="layer-container">
                        <div class="paragraph-medium paragraph-black">
                            The emergency department staff may not be aware of your medical background, so they ask a lot of questions. Sometimes, this needs to be done by more than one healthcare worker.

                            To help the staff assess and treat you, tell them about:
                            the reason you came to the emergency department
                            any health problems you have had in the past
                            all medication and treatments you are using
                            any allergies
                            any recent trips overseas
                            if you are pregnant or breastfeeding
                            any other facts they should know about.
                        </div>
                        <div class="emergency-number">Call : 01738363303</div>
                    </div>
                </div>
            </div>
        </div>

        <a href="showdoctorlist"><div id="appointment-button" class="animated fadeInUp">
                <button id="appointment-now" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--raised"><i class="fa fa-plus"></i></button>
                <div class="mdl-tooltip mdl-tooltip--top" data-mdl-for="showdoctorlist">Make An Appointment</div>
            </div></a><!-- End Fixed Appointment Button at Bottom -->
        <!-- Start Footer Section -->
        <footer id="footer">
            <div class="layer-stretch">
                <!-- Start main Footer Section -->
                <div class="row layer-wrapper">
                    <div class="col-md-4 footer-block">
                        <div class="footer-ttl"><p>Basic Info</p></div>
                        <div class="footer-container footer-a">
                            <div class="tbl">
                                <div class="tbl-row">
                                    <div class="tbl-cell"><i class="fa fa-map-marker"></i></div>
                                    <div class="tbl-cell">
                                        <p class="paragraph-medium paragraph-white">
                                            S.R Diagnostic Center<br />
                                            Dendabor, Savar<br />
                                            Dhaka, Bangladesh
                                        </p>
                                    </div>
                                </div>
                                <div class="tbl-row">
                                    <div class="tbl-cell"><i class="fa fa-phone"></i></div>
                                    <div class="tbl-cell">
                                        <p class="paragraph-medium paragraph-white">01738363303</p>
                                    </div>
                                </div>
                                <div class="tbl-row">
                                    <div class="tbl-cell"><i class="fa fa-envelope"></i></div>
                                    <div class="tbl-cell">
                                        <p class="paragraph-medium paragraph-white">sakibulrasel@gmail.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 footer-block">
                        <div class="footer-ttl"><p>Quick Links</p></div>
                        <div class="footer-container footer-b">
                            <div class="tbl">
                                <div class="tbl-row">

                                    <ul class="tbl-cell">
                                        <li><a href="login">Login</a></li>
                                        <li><a href="patientsignup">Register</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 footer-block">
                        <div class="footer-ttl"><p>Newsletter</p></div>
                        <div class="footer-container footer-c">
                            <div class="footer-subscribe">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input">
                                    <input class="mdl-textfield__input" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" id="subscribe-email">
                                    <label class="mdl-textfield__label" for="subscribe-email">Your Email</label>
                                    <span class="mdl-textfield__error">Please Enter Valid Email!</span>
                                </div>
                                <div class="footer-subscribe-button">
                                    <button class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Submit</button>
                                </div>
                            </div>
                            <ul class="social-list social-list-colored footer-social">
                                <li>
                                    <a href="#" target="_blank" id="footer-facebook" class="fa fa-facebook"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-facebook">Facebook</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-twitter" class="fa fa-twitter"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-twitter">Twitter</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-google" class="fa fa-google"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-google">Google</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-instagram" class="fa fa-instagram"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-instagram">Instagram</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-youtube" class="fa fa-youtube"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-youtube">Youtube</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-linkedin" class="fa fa-linkedin"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-linkedin">Linkedin</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-flickr" class="fa fa-flickr"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-flickr">Flickr</span>
                                </li>
                                <li>
                                    <a href="#" target="_blank" id="footer-rss" class="fa fa-rss"></a>
                                    <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-rss">Rss</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div><!-- End main Footer Section -->
            <!-- Start Copyright Section -->
            <div id="copyright">
                <div class="layer-stretch">
                    <div class="paragraph-medium paragraph-white">2018 © Sakibul ALL RIGHTS RESERVED.</div>
                </div>
            </div><!-- End of Copyright Section -->
        </footer><!-- End of Footer Section -->

        <!-- **********Included Scripts*********** -->

        <!-- Jquery Library 2.1 JavaScript-->
        <script src="resources/resource/js/jquery-2.1.4.min.js"></script>
        <!-- Popper JavaScript-->
        <script src="resources/resource/js/popper.min.js"></script>
        <!-- Bootstrap Core JavaScript-->
        <script src="resources/resource/js/bootstrap.min.js"></script>
        <!-- Material Design Lite JavaScript-->
        <script src="resources/resource/js/material.min.js"></script>
        <!-- Material Select Field Script -->
        <script src="resources/resource/js/mdl-selectfield.min.js"></script>
        <!-- Flexslider Plugin JavaScript-->
        <script src="resources/resource/js/jquery.flexslider.min.js"></script>
        <!-- Owl Carousel Plugin JavaScript-->
        <script src="resources/resource/js/owl.carousel.min.js"></script>
        <!-- Scrolltofixed Plugin JavaScript-->
        <script src="resources/resource/js/jquery-scrolltofixed.min.js"></script>
        <!-- Magnific Popup Plugin JavaScript-->
        <script src="resources/resource/js/jquery.magnific-popup.min.js"></script>
        <!-- WayPoint Plugin JavaScript-->
        <script src="resources/resource/js/jquery.waypoints.min.js"></script>
        <!-- CounterUp Plugin JavaScript-->
        <script src="resources/resource/js/jquery.counterup.js"></script>
        <!-- SmoothScroll Plugin JavaScript-->
        <script src="resources/resource/js/smoothscroll.min.js"></script>
        <!--Custom JavaScript for Klinik Template-->
        <script src="resources/resource/js/custom.js"></script>
        <script>
                (function (i, s, o, g, r, a, m) {
                    i['GoogleAnalyticsObject'] = r;
                    i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
                    a = s.createElement(o),
                            m = s.getElementsByTagName(o)[0];
                    a.async = 1;
                    a.src = g;
                    m.parentNode.insertBefore(a, m)
                })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

                ga('create', 'UA-93901876-1', 'auto');
                ga('send', 'pageview');
        </script>
    </body>
</html>
