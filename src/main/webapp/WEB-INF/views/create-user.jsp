<%--
  Created by IntelliJ IDEA.
  User: souhail
  Date: 10/07/2023
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign-up</title>

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
                            <img src="https://www.immodf.fr/wp-content/uploads/2020/10/agence-immobiliere-vedre-plus-vite-1170x0-c-center.jpg"
                                 alt="login form" class="img-fluid"
                                 style="border-radius: 1rem 0 0 1rem; height: 100% ;object-fit: fill;"/>
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form:form modelAttribute="user" method="post" action="sign-up">


                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <span class="h1 fw-bold mb-0">Créer votre compte</span>
                                    </div>


                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="firstName">Prénom</label>
                                        <form:input path="firstName"
                                                    id="firstName"
                                                    cssClass="form-control form-control-lg"
                                                    cssErrorClass="form-control form-control-lg is-invalid"
                                        />
                                        <div id="validationServer03Feedback" class="text-danger">
                                            <form:errors path="firstName"/>
                                        </div>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="lastName">Nom</label>
                                        <form:input path="lastName"
                                                    id="lastName"
                                                    cssClass="form-control form-control-lg"
                                                    cssErrorClass="form-control form-control-lg is-invalid"
                                        />
                                        <div id="validationServer03Feedback" class="text-danger">
                                            <form:errors path="lastName"/>
                                        </div>
                                    </div>


                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="email">Email</label>
                                        <form:input path="email"
                                                    id="email"
                                                    cssClass="form-control form-control-lg"
                                                    cssErrorClass="form-control form-control-lg is-invalid"
                                        />
                                        <div id="validationServer03Feedback" class="text-danger">
                                            <form:errors path="email"/>
                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="email">Password</label>
                                        <form:input path="password"
                                                    id="password"
                                                    cssClass="form-control form-control-lg"
                                                    cssErrorClass=" form-control form-control-lg is-invalid"
                                        />
                                        <div id="validationServer03Feedback" class="text-danger">
                                            <form:errors path="password"/>
                                        </div>
                                    </div>



                                    <div class="pt-1 mb-4">
                                        <input class="btn btn-dark btn-lg btn-block" type="submit" value="Gooo"/>
                                    </div>

                                </form:form>

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
