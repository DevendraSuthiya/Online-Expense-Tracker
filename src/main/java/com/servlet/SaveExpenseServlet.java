package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;


@WebServlet("/saveExpense")
public class SaveExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String payWay = request.getParameter("payment_way");
		String price = request.getParameter("price");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Expense ex = new Expense(title ,date,time,payWay,description,price,user);
		ExpenseDao dao= new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f= dao.saveExpense(ex);
		if(f) {
			session.setAttribute("msg", "Expense added sucessfully");
			response.sendRedirect("user/add_expense.jsp");
		}else {
			session.setAttribute("msg","Someting went wron on server try again" );
			response.sendRedirect("user/add_expense.jsp");
		}
	}

}
