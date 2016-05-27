package com.dishtech.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.omg.CORBA.Request;

import com.dishtech.beans.Car;
import com.dishtech.beans.UsedCar;
import com.dishtech.service.CarService;

public class CarController {
	/** 
	 * The request comes from the servlet for searching cars.
	 * This would return a car object containing models of cars.
	 * 
	 * The user will provide the name of the car
	 *
	 * 
	 * @return Car
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public Car searchCars(String name) throws ClassNotFoundException, SQLException{
		CarService carService = CarService.getInstance(); // Instance refers to the copy of the object at a run time whereas object refers to the memory address of the class.
		Car car = carService.searchCars(name);
		System.out.println("---- return car from controller ------");
		return car;
	}
	
	/** 
	 * The request comes from the servlet for fetching the model details
	 * This would return a car object containing details of model of cars.
	 *
	 *
	 * 
	 * @return Car
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Car fetchModelDetails(String modelName,String carName) throws ClassNotFoundException, SQLException{
		CarService carService = CarService.getInstance();
		System.out.println( "---- Entered car controller ---- ");
		
		Car car = carService.fetchModelDetails(modelName,carName);
		System.out.println("---- return from car service ---- ");
		
		return car;
	}
	/**
	 * This method creates a new car with the parameters sent by the user.
	 * 
	 * The car details are stored in the database
	 * 
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int sellCar(String name, String color, Long price, String city, Long modelYear) throws SQLException, ClassNotFoundException{
		
		System.out.println("--- enter sell car in car controller-------");
		UsedCar usedcar = new UsedCar();
		ArrayList<UsedCar> usList = new ArrayList<UsedCar>();
		Car car = new Car();
		
		usedcar.setCarName(name);
		
		usedcar.setCity(city);
		
		usedcar.setColor(color);
		
		usedcar.setModelYear(modelYear);
		
		usedcar.setPrice(price);
		
		System.out.println("--- values set successfully ---");
		
		usList.add(usedcar);
		car.setUsedcar(usList);
		
		CarService carservice = CarService.getInstance();
		int x = carservice.sellCar(car);
		return x; 
		//Create the service object
		//Pass the required parameters to create the usedCar object
		//Pass the control from service class to DAO class to create the used car object
	}	
	
	/**
	 * This method is used to take in the user information for buying the car
	 * 
	 * The information will include
	 * Budget and city
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * 
	 */
	public List<UsedCar> buyUsedCar(String carName,Long maxprice,String city) throws SQLException, ClassNotFoundException{
		
		CarService carservice = CarService.getInstance();
		UsedCar usedcar = new UsedCar();
		
		if(carName==usedcar.getCarName());
		{
		List<UsedCar> list = new ArrayList<UsedCar>();
		list = carservice.buyUsedCar(carName,maxprice, city);
		System.out.println(" --- return to carcontroller -----");
		return list;
		}
		//Create the service object.
		//Pass the budget and city to the service class
		//Pass the control from service to DAO class and based on budget and city, find the 
		//cars from usedCars table which are in same city ans lies in the price range defined by the user
		
	}
}

	