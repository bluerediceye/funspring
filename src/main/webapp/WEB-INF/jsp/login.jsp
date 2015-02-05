<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login Form</title>
    <link rel="stylesheet" href="css/style.css">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

    <style type="text/css">
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body onload="document.f.j_username.focus();">

<c:if test="${not empty error}">
    <div class="errorblock">
        Your login was unsuccessful. <br/>
        Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>

<section class="container">
    <div class="login">
        <h1>Login to Web App</h1>

        <form method="post" action="<c:url value="/j_spring_security_check"/>" name="f">
            <p><input type="text" name="j_username" value="" placeholder="Username or Email" required></p>

            <p><input type="password" name="j_password" value="" placeholder="Password" required></p>

            <p class="remember_me">
                <label>
                    <input type="checkbox" name="_spring_security_remember_me" id="remember_me">
                    Remember me on this computer
                </label>
            </p>

            <p class="submit"><input type="submit" name="commit" value="Login"></p>
        </form>
    </div>

    <div class="login-help">
        <p>Forgot your password? <a href="login.jsp">Click here to reset it</a>.</p>
    </div>
</section>

<%--<section class="about">
  <p class="about-links">
    <a href="http://www.cssflow.com/snippets/login-form" target="_parent">View Article</a>
    <a href="http://www.cssflow.com/snippets/login-form.zip" target="_parent">Download</a>
  </p>
  <p class="about-author">
    &copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> -
    <a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>
    Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
</section>--%>
</body>
</html>
