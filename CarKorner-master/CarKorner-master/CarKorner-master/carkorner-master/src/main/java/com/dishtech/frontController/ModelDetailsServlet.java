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
import com.dishtech.beans.Specifications;
import com.dishtech.controller.CarController;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class ModelDetailsServlet
 */
public class ModelDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ModelDetailsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Float modelId = Float.parseFloat(request.getParameter("modelId"));
		String modelName = request.getParameter("modelName");
		String carName = request.getParameter("carName");
		
		System.out.println("--- model id is : " +modelId);
		System.out.println("--- model name is :" +modelName);
		System.out.println("--- Car name is :" +carName);
		
		CarController carController  = new CarController();
		
		try {
			Car car = carController.fetchModelDetails(modelName,carName);
			
			System.out.println(car.getCarName());
			System.out.println(car.getModelName());
			
			ArrayList<String> list = car.getColorName();
			Iterator<String> it = list.iterator();
			System.out.println("----- all colors -------------");
			
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
			
			System.out.println("---- now features -----");
			
			ArrayList<Boolean> feature = car.getFeature();
			Iterator<Boolean> ite = feature.iterator();
			
			while(ite.hasNext())
			{
				System.out.println(ite.next());
			}
			
			Specifications sp = new Specifications();
			sp=car.getSp();
			
			System.out.println("bootspace is : " +sp.getBootSpace());
			System.out.println("wheelbas :" +sp.getWheelBase());
			request.setAttribute("car",car);
			
			RequestDispatcher rd = request.getRequestDispatcher("screens/modelDetails.jsp");
			System.out.println("forward to model details jsp");
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
