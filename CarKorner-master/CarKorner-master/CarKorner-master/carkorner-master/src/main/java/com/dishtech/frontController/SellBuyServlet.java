package com.dishtech.frontController;

import java.io.IOException;
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
		carcontroller.sellCar(carName, carColor, carPrice, city, modelYear);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
