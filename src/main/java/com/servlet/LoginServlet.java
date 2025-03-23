package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;


@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		User u = dao.login(email, password);
		HttpSession session = request.getSession();
		if(u==null) {
			session.setAttribute("msg", "Invalid email and password");
			response.sendRedirect("login.jsp");
			
			
		}else {
			session.setAttribute("msg", "");
			session.setAttribute("user", u);
			response.sendRedirect("user/home.jsp");
		}
		
	}

}
