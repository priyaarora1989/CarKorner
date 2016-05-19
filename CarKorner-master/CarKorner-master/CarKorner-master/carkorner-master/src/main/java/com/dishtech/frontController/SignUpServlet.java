package com.dishtech.frontController;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dishtech.controller.UserController;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name,email,password;
		 long  contactno;
		 
		name=request.getParameter("newusername");
		
		email=request.getParameter("emailid");
		
		contactno=Integer.parseInt(request.getParameter("contactnumber"));
		
		password=request.getParameter("password");
			
			
		UserController usercontroller = new UserController();
	
			try {
				usercontroller.createUser(name, email, password, contactno);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" ---servlet page ---");
		
			
			System.out.println(request.getAttribute("flag"));
			RequestDispatcher rd = request.getRequestDispatcher("screens/signup.jsp");
			rd.forward(request, response);
	}

}
