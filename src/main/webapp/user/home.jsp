<%@page import="com.db.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expense-Tracker</title>
    
    <%@include file="/component/all_css.jsp"%>

    <style>
        body {
            overflow: hidden;
        }

        .carousel-inner img {
            width: 100%;
            height: 87vh;
            object-fit: cover;
        }
    </style>
</head>
<body>

    <%@include file="/component/navbar.jsp"%>

    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="../img/img1.jpg" class="d-block w-100" alt="Slide 1">
            </div>
            <div class="carousel-item">
                <img src="../img/img2.jpg" class="d-block w-100" alt="Slide 2">
            </div>
            <div class="carousel-item">
                <img src="../img/img3.jpg" class="d-block w-100" alt="Slide 3">
            </div>
        </div>
        
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>

        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <footer class="bg-dark text-white text-center py-3">
    &copy; 2025 Your Website Name. All Rights Reserved.
</footer>
    

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var myCarousel = new bootstrap.Carousel(document.querySelector("#carouselExampleControls"), {
                interval: 3000,
                wrap: true
            });
        });
    </script>

</body>
</html>
