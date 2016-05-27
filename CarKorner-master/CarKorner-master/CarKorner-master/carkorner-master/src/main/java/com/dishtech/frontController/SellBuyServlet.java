package com.dishtech.frontController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dishtech.controller.CarController;

/**
 * Servlet implementation class SellBuyServlet
 */
public class SellBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" --- enter sellbuyservlet ----");
		
		String carName,carColor,city;
		Long carPrice,modelYear;
		
		carName = request.getParameter("carName");
		carColor = request.getParameter("carColor");
		city = request.getParameter("city");
		carPrice = Long.parseLong(request.getParameter("carPrice"));
		modelYear = Long.parseLong(request.getParameter("modelYear"));
		
		CarController carcontroller = new CarController();
		
		System.out.println("-----object created ------");
		try {
			int x = carcontroller.sellCar(carName, carColor, carPrice, city, modelYear);
			RequestDispatcher rd = request.getRequestDispatcher("screens/sellcar.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
