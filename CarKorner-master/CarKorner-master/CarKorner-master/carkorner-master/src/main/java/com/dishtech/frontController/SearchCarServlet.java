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

import com.dishtech.beans.Car;
import com.dishtech.beans.Model;
import com.dishtech.controller.CarController;
import com.dishtech.dao.CarDAO;
import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * Servlet implementation class SearchCarServlet
 * 
 * This servlet should be used to search the car models
 * 
 */
public class SearchCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchCarServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carName = request.getParameter("search");
		System.out.println(" car name entred :" +carName);
		
		CarController carController = new CarController();
		try {
				Car car	= carController.searchCars(carName);
				ArrayList<Model> list = new ArrayList<Model>();
				
				String newCarName = car.getCarName();
				System.out.println("-- new car name is :   " +newCarName);
				
				Float carPrice = car.getCarPrice();
				System.out.println("- car price is :" +carPrice);
				
				list = car.getList();
				
				for(Model model : list)
				{
					Float modelId = model.getModelId();
					System.out.println(" model id is : " +modelId);
					
					String modelName = model.getModelName();
					System.out.println(" model price is : " +modelName);		
				}			
			RequestDispatcher rd = request.getRequestDispatcher("screens/search.jsp");
			System.out.println("------ forwarded to search.jsp ---- ");
			
			request.setAttribute("car",car);
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
