<%--
  Created by IntelliJ IDEA.
  User: souhail
  Date: 16/07/2023
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #9A616D;">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/adverts">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <sec:authorize access="hasAnyRole('ROLE_Guest','ROLE_Agent')">
        <span class="navbar-text">
                <sec:authentication property="principal"/>

            <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/logout">Logout</a>

        </span>
        </sec:authorize>

    </div>
</nav>
