package com.dishtech.service;

import java.sql.SQLException;

import com.dishtech.beans.Car;
import com.dishtech.beans.UsedCar;
import com.dishtech.dao.CarDAO;

public class CarService implements ICarService {
	
	private static CarService carService = new CarService();
	
	public static CarService getInstance(){
		return carService;
	}
	

	public Car searchCars(String name) throws ClassNotFoundException, SQLException{
		
		System.out.println("------- enter searchcars in service ------- ");
		
		CarDAO carDAO = new CarDAO();
		carDAO.getConnection();
		
		System.out.println("---- get connectoin completed -----");
		
		Car car = carDAO.searchCars(name);
		System.out.println("--- return car from service -------");
		return car;
	}


	public Car fetchModelDetails(String modelName, String carName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println(" ---  enter fetch details in service ------");
		
		CarDAO carDao = new CarDAO();
		carDao.getConnection();
		
		System.out.println("--- connection completed -----");
		
			Car car = carDao.fetchDetails(modelName, carName);
		System.out.println("--- return from dao----");
		return car;
	}
	
	public int sellCar(UsedCar usedcar)
	{
		CarDAO cardao = new CarDAO();
		cardao.sellCar(usedcar);
		return 1;
	}
}
