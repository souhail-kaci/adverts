<%--
  Created by IntelliJ IDEA.
  User: souhail
  Date: 03/07/2023
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forget Password</title>

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>
<section class="vh-100" style="background-color: #9A616D;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="https://www.immoz.info/wp-content/uploads/2019/03/gestion-de-cl%C3%A9s-3.jpg"
                                 alt="login form" class="img-fluid"
                                 style="border-radius: 1rem 0 0 1rem; height: 100% ;object-fit: fill;"/>
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form method="post" action="forgot-password">

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <span class="h1 fw-bold mb-0">Forget your password ? Don't worry </span>
                                    </div>

                                    <c:if test="${not empty error}">
                                        <h5 class="fw-normal mb-3 pb-3 text-danger" style="letter-spacing: 1px;">
                                            <c:out value="${error}"/>
                                        </h5>

                                    </c:if>

                                    <c:if test="${not empty succes}">
                                        <h5 class="fw-normal mb-3 pb-3 text-success" style="letter-spacing: 1px;">
                                            <c:out value="${succes}"/>
                                        </h5>

                                    </c:if>


                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Enter your email</h5>

                                    <div class="form-outline mb-4">
                                        <input type="email" name="email" id="form2Example17"
                                               class="form-control form-control-lg" required/>
                                        <label class="form-label" for="form2Example17">Email address</label>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <input class="btn btn-dark btn-lg btn-block" type="submit"/>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
