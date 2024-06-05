<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">

    <style type="text/css">/* Chart.js */
    @keyframes chartjs-render-animation {
        from {
            opacity: .99
        }
        to {
            opacity: 1
        }
    }

    .chartjs-render-monitor {
        animation: chartjs-render-animation 1ms
    }

    .chartjs-size-monitor, .chartjs-size-monitor-expand, .chartjs-size-monitor-shrink {
        position: absolute;
        direction: ltr;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        overflow: hidden;
        pointer-events: none;
        visibility: hidden;
        z-index: -1
    }

    .chartjs-size-monitor-expand > div {
        position: absolute;
        width: 1000000px;
        height: 1000000px;
        left: 0;
        top: 0
    }

    .chartjs-size-monitor-shrink > div {
        position: absolute;
        width: 200%;
        height: 200%;
        left: 0;
        top: 0
    }</style>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">CarManager <sup>1</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>

    <div id="content-wrapper" class="d-flex flex-column">


        <div id="content">


            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"></nav>
            <div class="d-sm-flex align-items-center justify-content-between mb-4" style="padding-left: 0.5cm">
                <h1 class="h3 mb-0 text-gray-800">CarManager</h1>
                <a style="padding-right: 0.5cm" href="<c:url value="/WEB-INF/carList.jsp"/>"
                   class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                    <i class="fas fa-download fa-sm text-white-50"></i>Lista aut</a>
            </div>
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Dodaj auto do bazy</h6>
                </div>
                <div class="card-body">
                    <form:form method="post" modelAttribute="car">
                        <div class="form-group">
                            <label for="marka">Marka</label>
                            <form:input path="marka" type="text" class="form-control" id="marka"
                                        placeholder="podaj markę auta"></form:input>
                        </div>

                        <div class="form-group">
                            <label for="model">Model</label>
                            <form:input path="model" type="text" class="form-control" id="model"
                                        placeholder="podaj model auta"></form:input>
                        </div>

                        <div class="form-group">
                            <label for="pojemnosc">Pojemność silnika</label>
                            <form:input path="pojemnosc" type="text" class="form-control" id="pojemnosc"
                                        placeholder="podaj pojemność silnika"></form:input>
                        </div>

                        <div class="form-group">
                            <%--@declare id="paliwo"--%><label for="paliwo">Rodzaj paliwa</label>
                            <c:forEach items="${paliwo}" var="lang">
                                ${lang}<br>
                            </c:forEach>
                        </div>

                        <div class="form-group">
                            <label for="przebieg">Przebieg</label>
                            <form:input path="przebieg" type="text" class="form-control" id="przebieg"
                                        placeholder="podaj przebieg auta"></form:input>
                        </div>

<%--                        <div class="form-group">--%>
<%--                            <label for="ostatni_przeglad">Ostatnio wykonany przegląd</label>--%>
<%--                            <input name="ostatni_przeglad" type="date" class="form-control" id="ostatni_przeglad"--%>
<%--                                   placeholder="podaj datę ostatnio wykonanego przeglądu">--%>
<%--                        </div>--%>

                        <button type="submit" class="btn btn-primary">Zapisz</button>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
