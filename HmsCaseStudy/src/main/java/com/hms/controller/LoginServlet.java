package com.hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bean.LoginBean;
import com.hms.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private LoginDao loginDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public void init() {
	        loginDao = new LoginDao();
	    }
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {

			        String login = request.getParameter("login");
			        String password = request.getParameter("password");
			        LoginBean loginBean = new LoginBean();
			        loginBean.setUsername(login);
			        loginBean.setPassword(password);

			        try {
			            if (loginDao.validate(loginBean)) {
			                //HttpSession session = request.getSession();
			                // session.setAttribute("username",username);
			                response.sendRedirect("loginSuccess.jsp");
			            } else {
			                HttpSession session = request.getSession();
			                //session.setAttribute("user", username);
			                //response.sendRedirect("login.jsp");
			            }
			        } catch (ClassNotFoundException e) {
			            e.printStackTrace();
			        }
			    }
}
