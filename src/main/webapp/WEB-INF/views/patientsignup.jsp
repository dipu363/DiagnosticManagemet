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
        <title>Klinik health care - HTML5 &#38; CSS3 Template for Clinic and Hospital</title>
        <!-- Meta Description Tag -->
        <meta name="Description" content="Klinik is a HTML5 & CSS3 responsive template">
        <!-- Favicon Icon -->
        <link rel="icon" type="image/x-icon" href="resources/images/favicon.png" />
        <!-- Font Awesoeme Stylesheet CSS -->
        <link rel="stylesheet" href="resources/resource/font-awesome/css/font-awesome.min.css" />
        <!-- Google web Font -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:400,500">
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
    </head>
    <body>
        <!-- Start Header -->
        <header id="header">
            <!-- Start Header Top Section -->
            <div id="hdr-top-wrapper">
                <div class="layer-stretch hdr-top">
                    <div class="hdr-top-block hidden-xs">
                        <div id="hdr-social">
                            <ul class="social-list social-list-sm">
                                <li><a class="width-auto font-13">Follow Us : </a></li>
                                <li><a href="#" target="_blank" id="hdr-facebook" ><i class="fa fa-facebook" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-facebook">Facebook</span></li>
                                <li><a href="#" target="_blank" id="hdr-twitter" ><i class="fa fa-twitter" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-twitter">Twitter</span></li>
                                <li><a href="#" target="_blank" id="hdr-google" ><i class="fa fa-google" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-google">Google</span></li>
                                <li><a href="#" target="_blank" id="hdr-instagram" ><i class="fa fa-instagram" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-instagram">Instagram</span></li>
                                <li><a href="#" target="_blank" id="hdr-youtube" ><i class="fa fa-youtube" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-youtube">Youtube</span></li>
                                <li><a href="#" target="_blank" id="hdr-linkedin" ><i class="fa fa-linkedin" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-linkedin">Linkedin</span></li>
                                <li><a href="#" target="_blank" id="hdr-flickr" ><i class="fa fa-flickr" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-flickr">Flickr</span></li>
                                <li><a href="#" target="_blank" id="hdr-rss" ><i class="fa fa-rss" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-rss">Rss</span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="hdr-top-line hidden-xs"></div>
                    <div class="hdr-top-block hdr-number">
                        <div class="font-13">
                            <i class="fa fa-mobile font-20 tbl-cell"> </i> <span class="hidden-xs tbl-cell"> Emergency Number : </span> <span class="tbl-cell">01738363303</span>
                        </div>
                    </div>
                    <div class="hdr-top-line"></div>
                    <div class="hdr-top-block">
                        <div class="theme-dropdown">
                            <a id="profile-menu" class="mdl-button mdl-js-button mdl-js-ripple-effect font-13"><i class="fa fa-user-o color-black"></i> My Account</a>
                            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect metarial-menu" data-mdl-for="profile-menu">
                                <li class="mdl-menu__item"><a href="login"><i class="fa fa-sign-in"></i>Login</a></li>

                                <li class="mdl-menu__item"><a href="patientsignup"><i class="fa fa-user-o"></i>Register</a></li>

                                <li class="mdl-menu__item"><a href="about"><i class="fa fa-info"></i>Help</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div><!-- End Header Top Section -->
            <!-- Start Main Header Section -->
            <div id="hdr-wrapper">
                <div class="layer-stretch hdr">
                    <div class="tbl">
                        <div class="tbl-row">
                            <!-- Start Header Logo Section -->
                            <div class="tbl-cell hdr-logo">
                                <a href="index"><img src="resources/images/logo.png" alt=""></a>
                            </div><!-- End Header Logo Section -->
                            <div class="tbl-cell hdr-menu">
                                <!-- Start Menu Section -->
                                <ul class="menu">
                                    <li>
                                        <a id="menu-home" href="index" class="mdl-button mdl-js-button mdl-js-ripple-effect">Home <i class="fa fa-chevron-down"></i></a>

                                    </li>
                                    <li class="menu-megamenu-li">
                                        <a id="menu-pages" class="mdl-button mdl-js-button mdl-js-ripple-effect">Pages <i class="fa fa-chevron-down"></i></a>

                                    </li>

                                    <li>
                                        <a id="menu-profile" class="mdl-button mdl-js-button mdl-js-ripple-effect">Doctor <i class="fa fa-chevron-down"></i></a>
                                        <ul class="menu-dropdown">
                                            <li><a href="showdoctorlist">Doctor</a></li>



                                        </ul>
                                    </li>

                                    <li>
                                        <a id="menu-profile" class="mdl-button mdl-js-button mdl-js-ripple-effect">Profile <i class="fa fa-chevron-down"></i></a>
                                        <ul class="menu-dropdown">
                                            <li><a href="login">Login Page</a></li>

                                            <li><a href="patientsignup">Register Page</a></li>

                                        </ul>
                                    </li>


                                    <li class="mobile-menu-close"><i class="fa fa-times"></i></li>
                                </ul><!-- End Menu Section -->
                                <div id="menu-bar"><a><i class="fa fa-bars"></i></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- End Main Header Section -->
        </header><!-- End Header -->
        <!-- Start Page Title Section -->
        <div class="page-ttl">
            <div class="layer-stretch">
                <div class="page-ttl-container">
                    <h1>Register</h1>
                    <p><a href="index">Home</a> &#8594; <span>Register</span></p>
                </div>
            </div>
        </div><!-- End Page Title Section -->
        <!-- Start Register Section -->
        <div class="layer-stretch">
            <div class="layer-wrapper">
                <div class="form-container">
                    <form:form modelAttribute="patient" action="addingpatient" enctype="multipart/form-data">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-user-o"></i>
                            <form:input class="mdl-textfield__input" type="text" path="fname" required="true" id="register-name"></form:input>
                                <label class="mdl-textfield__label" for="register-name">First Name <em> *</em></label>

                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-user-o"></i>
                            <form:input class="mdl-textfield__input" type="text" path="lname" required="true" id="register-lname"></form:input>
                                <label class="mdl-textfield__label" for="register-lname">Last Name <em> *</em></label>

                            </div>

                            


                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-envelope-o"></i>
                            <form:input class="mdl-textfield__input" type="text"  path="emailid" required="true" id="register-email"></form:input>
                                <label class="mdl-textfield__label" for="register-email">Email <em> *</em></label>
                                <span class="mdl-textfield__error">Please Enter Valid Email!</span>
                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-mobile"></i>
                            <form:input class="mdl-textfield__input" type="text" path="mobile" required="true" id="register-phone"></form:input>
                                <label class="mdl-textfield__label" for="register-phone">Mobile Number <em> *</em></label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-key"></i>
                            <form:input class="mdl-textfield__input" type="password" path="password" required="true" id="register-pass"></form:input>
                                <label class="mdl-textfield__label" for="register-pass">Password <em> *</em></label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-chevron-down"></i>
                            <form:input class="mdl-textfield__input" type="text" path="age" required="true" id="register-age"></form:input>
                                <label class="mdl-textfield__label" for="register-age">Age <em> *</em></label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-group"></i>
                                <form:select path="bloodgroup" id="register-bloodgroup">
                                                <form:option value="NONE" label="--- Select ---"/>

                                                <form:option value="A+" label="A+"/>
                                                <form:option value="A-" label="A-"/>
                                                <form:option value="B+" label="B+"/>
                                                <form:option value="B-" label="B-"/>
                                                <form:option value="O+" label="O+"/>
                                                <form:option value="O-" label="O-"/>
                                                <form:option value="AB+" label="AB+"/>
                                                <form:option value="AB-" label="AB-"/>
                                            </form:select>
                            
                                <label class="mdl-textfield__label" for="register-bloodgroup">Blood Group <em>   </em> </label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-asl-interpreting"></i>
                            <label class="radio-inline">
                            <form:radiobutton path="gender" checked="checked" value="Male" id="register-gender"/>Male </label> 
                            <label class="radio-inline"><form:radiobutton path="gender" value="Female" id="register-gender"/>Female</label>
                                <label class="mdl-textfield__label" for="register-gender">Gender  <em> *    </em></label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-life-ring"></i>
                            <label>
                            <form:radiobutton path="maritualstatus"  value="Married" id="register-Mar"/>Married </label> 
                            <label><form:radiobutton path="maritualstatus" checked="checked" value="Unmarried" id="register-gender"/>Unmarried</label>
                                <label class="mdl-textfield__label" for="register-Mar">Status</label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-address-card"></i>
                            <form:input class="mdl-textfield__input" type="text" path="address" required="true" id="register-add"></form:input>
                                <label class="mdl-textfield__label" for="register-add">Address <em> *</em></label>

                            </div>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-picture-o"></i>
                            <form:input class="mdl-textfield__input" type="file" path="pimage" required="true" name="fileToUpload" id="fileToUpload"></form:input>
                                

                            </div>
                                
                                <div class="login-condition">By clicking Creat Account you agree to our<br /><a href="#">terms &#38; condition</a></div>
                    <div class="form-submit">
                        <form:button type="submit" name="Addpatient" id="editpatientbutton" class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Create Account</form:button>
                    </div>
                                
                    </form:form>


                    
                    
                    <div class="or-using">Or Using</div>
                    <div class="social-login">
                        <a href="#" class="social-facebook"><i class="fa fa-facebook"></i>Facebook</a>
                        <a href="#" class="social-google"><i class="fa fa-google"></i>Google</a>
                    </div>
                    <div class="login-link">
                        <span class="paragraph-small">Already have an account?</span>
                        <a href="login" class="">Login Now</a>
                    </div>
                </div>

            </div>
        </div><!-- End Register Section -->
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

        <div id="appointment-button" class="animated fadeInUp">
            <button id="appointment-now" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--raised"><i class="fa fa-plus"></i></button>
            <div class="mdl-tooltip mdl-tooltip--top" data-mdl-for="showdoctorlist">Make An Appointment</div>
        </div><!-- End Fixed Appointment Button at Bottom -->
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