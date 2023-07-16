<%--
  Created by IntelliJ IDEA.
  User: souhail
  Date: 10/07/2023
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Adverts</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container mt-5">

    <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/add-advert"> Add new Advert</a>

    <div class="row row-cols-1 row-cols-md-3 g-4 mt-3">
        <c:forEach items="${adverts}" var="advert">
            <div class="col">
                <div class="card">
                    <img src="${advert.imageUrl}" class="card-img-top" alt="test">
                    <div class="card-body">
                        <h5 class="card-title">${advert.type} </h5>
                            <p class="card-text">${advert.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>


</div>


</body>
</html>
