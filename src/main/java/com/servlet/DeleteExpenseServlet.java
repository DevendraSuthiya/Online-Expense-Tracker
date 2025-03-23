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


@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int id = Integer.parseInt(request.getParameter("id"));
	      ExpenseDao dao= new ExpenseDao(HibernateUtil.getSessionFactory());
	      boolean flag = dao.deleteExpense(id);
	      HttpSession session = request.getSession();
	      
	      if(flag) {
	    	  session.setAttribute("msg", "Deleted Successfully");
	    	  response.sendRedirect("user/view_expense.jsp");
	      }else {
	    	  session.setAttribute("msg", "Something went wrong please try again");
	    	  response.sendRedirect("user/view_expense.jsp");
	      }
	}

}
