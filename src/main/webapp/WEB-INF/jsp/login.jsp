<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Tutorial Custom Login Page</title>
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
<h3>Tutorial Custom Login Page</h3>
<%--@elvariable id="error" type="java.lang.String"--%>
<c:if test="${not empty error}">
    <div class="errorblock">
        Your login was unsuccessful. <br/>
        Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>

<form action="<c:url value="/j_spring_security_check"/>" name="f" method="post">
    <table>
        <tr>
            <td><label for="j_username" data-value="User:"></label></td>
            <td>
                <input id="j_username" type="text" name="j_username"/>
            </td>
        </tr>
        <tr>
            <td><label for="j_password" data-value="Password:"></label></td>
            <td>
                <input id="j_password" type="password" name="j_password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="Submit" value="Submit"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="reset" name="Reset" value="Rest"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
