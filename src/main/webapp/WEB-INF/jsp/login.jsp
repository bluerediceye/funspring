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


<form action="/j_spring_security_check" name="f" method="post">
    <table>
        <tr>
            <td>User:</td>
            <td>
                <input type="text" name="j_username"/>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <input type="password" name="j_password"/>
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
