<%@page import="com.db.HibernateUtil"%>
<%@page import="com.entity.Expense"%>
<%@page import="com.dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<%@include file="/component/all_css.jsp"%>
<style>
body {
	overflow: hidden;
}

.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3)
}
</style>
</head>
<body class="bg-light">

<c:if test="${empty user }">
   <c:redirect url="../login.jsp"></c:redirect>

</c:if>
<%
int id = Integer.parseInt(request.getParameter("id"));
ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
Expense ex=dao.getExpenseById(id);
%>
	<%@include file="/component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card card-sh">
					<div class="card-header text-center">
						<p class="fs-3">Edit Expense</p>
						<c:if test="${not empty msg }">
						<p class="text-center text-success fs-4">${msg }</p>
						<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="../updateExpense" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title" value="<%=ex.getTitle() %>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Date</label> <input type="date" name="date" value="<%=ex.getDate() %>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Time</label> <input type="time" name="time" value="<%=ex.getTime() %>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Description</label> <input type="text" name="description" value="<%=ex.getDescription() %>"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Payment Method</label>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="payment_way"
										value="upi" id="upi" <%= "upi".equals(ex.getPayWay()) ? "checked" : "" %>> <label
										class="form-check-label" for="upi">UPI</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="payment_way"
										value="debit_card" id="debit_card" <%= "debit_card".equals(ex.getPayWay()) ? "checked" : "" %>> <label
										class="form-check-label" for="debit_card">Debit Card</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="payment_way"
										value="credit_card" id="credit_card" <%= "credit_card".equals(ex.getPayWay()) ? "checked" : "" %>> <label
										class="form-check-label" for="credit_card">Credit Card</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="payment_way"
										value="net_banking" id="net_banking" <%= "net_banking".equals(ex.getPayWay()) ? "checked" : "" %>> <label
										class="form-check-label" for="net_banking">Net Banking</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="payment_way"
										value="cash" id="cash" <%= "cash".equals(ex.getPayWay()) ? "checked" : "" %>> <label
										class="form-check-label" for="upi">Cash</label>
								</div>
							</div>

							<div class="mb-3">
								<label>Price</label> <input type="number" name="price" value="<%=ex.getPrice() %>"
									class="form-control">
							</div>
							<input type ="hidden" name="id" value="<%=ex.getId() %>">
							<button class="btn btn-success col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>