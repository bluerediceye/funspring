<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
    <title>Being Java Guys | Hello World</title>
</head>
<body>

<center>
    <h2>Welcome to Tutorial website <sec:authentication property="name"/></h2>
    <h4>
        <a href="hello.htm">Click Here</a>
    </h4>


    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <a>Add user</a>
    </sec:authorize>

    <a>Edit user</a>


</center>
</body>
</html> 