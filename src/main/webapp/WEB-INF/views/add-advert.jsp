<%--
  Created by IntelliJ IDEA.
  User: souhail
  Date: 10/07/2023
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<section class="vh-100" style="background-color: #ded0d2;">
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

                <form:form modelAttribute="advert" method="post" action="add-advert">


                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">Create Advert</span>
                  </div>


                  <div class="form-outline mb-4">
                    <label class="form-label" for="type">Type</label>
                    <form:input path="type"
                                id="type"
                                cssClass="form-control form-control-lg"
                                cssErrorClass="form-control form-control-lg is-invalid"
                    />
                    <div id="validationServer03Feedback" class="text-danger">
                      <form:errors path="type"/>
                    </div>

                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="description">Description</label>
                    <form:input path="description"
                                id="description"
                                cssClass="form-control form-control-lg"
                                cssErrorClass="form-control form-control-lg is-invalid"
                    />
                    <div id="validationServer03Feedback" class="text-danger">
                      <form:errors path="description"/>
                    </div>
                  </div>


                  <div class="form-outline mb-4">
                    <label class="form-label" for="status">Status</label>
                    <form:input path="status"
                                id="status"
                                cssClass="form-control form-control-lg"
                                cssErrorClass="form-control form-control-lg is-invalid"
                    />
                    <div id="validationServer03Feedback" class="text-danger">
                      <form:errors path="status"/>
                    </div>
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="imageUrl">ImageUrl</label>
                    <form:input path="imageUrl"
                                id="imageUrl"
                                cssClass="form-control form-control-lg"
                                cssErrorClass=" form-control form-control-lg is-invalid"
                    />
                    <div id="validationServer03Feedback" class="text-danger">
                      <form:errors path="imageUrl"/>
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
