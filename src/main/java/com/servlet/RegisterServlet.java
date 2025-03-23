package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName=request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String about = request.getParameter("about");
		User u = new User(fullName,email,password,about);
		//System.out.println(u);
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		boolean isRegister = dao.saveuser(u);
		HttpSession session = request.getSession();
		if(isRegister) {
			session.setAttribute("msg", "User Register Successfully");
			response.sendRedirect("register.jsp");
			
		}else {
			session.setAttribute("msg", "Something went wrong");

			response.sendRedirect("register.jsp");
		}
		
	}

}
