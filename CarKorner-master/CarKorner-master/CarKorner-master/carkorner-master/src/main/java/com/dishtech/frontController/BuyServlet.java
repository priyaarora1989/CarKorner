package com.dishtech.frontController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dishtech.beans.UsedCar;
import com.dishtech.controller.CarController;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class BuyServlet
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carName = request.getParameter("carName");
		
		Long minPrice = Long.parseLong(request.getParameter("minPrice"));
		
		Long maxPrice = Long.parseLong(request.getParameter("maxPrice"));
		
		String city = request.getParameter("city");
		
		Long ContactNumber=Long.parseLong(request.getParameter("contactNumber"));
		
		CarController carcontroller = new CarController();
			try {
				java.util.List<UsedCar> list = new ArrayList<UsedCar>();
				list = carcontroller.buyUsedCar(carName, maxPrice, city);
				request.setAttribute("list", list);
				UsedCar car = new UsedCar();
				
				System.out.println("--- return to buy servlet -----");
				
				Iterator<UsedCar> it = null;
				it = list.iterator();
				while(it.hasNext())
				{
					car = it.next();
					System.out.println("car name is :" +car.getCarName());
					System.out.println("car price si : " +car.getPrice());
				}
				
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("screens/buycar.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
