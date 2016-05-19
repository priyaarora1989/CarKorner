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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String loginName,loginPassword;
		
		loginName = request.getParameter("loginUsername");
		System.out.println("Loginname is " +loginName);
		
		loginPassword = request.getParameter("loginPassword");
		System.out.println("loggn password is " +loginPassword);
		
		UserController usercontroller = new UserController();
		try {
			Boolean b = usercontroller.loginUser(loginName, loginPassword);
			System.out.println(" boolean value :" +b);
			if(b==true)
			{
				System.out.println("search : " +b);
				RequestDispatcher rd = request.getRequestDispatcher("screens/search.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println(" login ");
				RequestDispatcher rd = request.getRequestDispatcher("screens/login.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
