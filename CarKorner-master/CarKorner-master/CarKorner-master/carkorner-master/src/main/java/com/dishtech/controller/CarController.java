package com.dishtech.controller;

import java.sql.SQLException;
import java.util.List;


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
	 */
	public void sellCar(String name, String color, Long price, String city, Long modelYear){
		
		System.out.println("--- enter sell car in car controller-------");
		UsedCar usedcar = new UsedCar();
		
		usedcar.setCarName(name);
		
		usedcar.setCity(city);
		
		usedcar.setColor(color);
		
		usedcar.setModelYear(modelYear);
		
		usedcar.setPrice(price);
		
		System.out.println("--- values set successfully ---");
		
		CarService carservice = CarService.getInstance();
		carservice.sellCar(usedcar);
		//Create the service object
		//Pass the required parameters to create the usedCar object
		//Pass the control from service class to DAO class to create the used car object
	}	
	
	/**
	 * This method is used to take in the user information for buying the car
	 * 
	 * The information will include
	 * Budget and city
	 * 
	 * 
	 */
	public List<UsedCar> buyUsedCar(){
		
		//Create the service object.
		//Pass the budget and city to the service class
		//Pass the control from service to DAO class and based on budget and city, find the 
		//cars from usedCars table which are in same city ans lies in the price range defined by the user
		return null;
	}
}

	