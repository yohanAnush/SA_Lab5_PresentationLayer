package com.sliit.sa.lab5.controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.sa.lab5.entities.Authenticator;
import com.sliit.sa.lab5.entities.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Authenticator authenticator = new Authenticator();
		User user = new User();
		RequestDispatcher dispatcher;
		
		user.setUsername(username);
		user.setPassword(password);
		
		// validate the login credentials.
		// redirect if info is correct.
		if (authenticator.authenticate(user)) {
			System.out.println("Login successfull; redirecting to home page.");
			
			request.setAttribute("user", user);	// embed user object.
			dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			System.out.println("Login unsuccessfull.");
			
			dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
