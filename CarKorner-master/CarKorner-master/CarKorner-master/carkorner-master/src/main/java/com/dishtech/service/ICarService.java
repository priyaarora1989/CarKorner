package com.dishtech.service;

import java.sql.SQLException;

import com.dishtech.beans.Car;

public interface ICarService {

	public Car searchCars(String name) throws ClassNotFoundException, SQLException;
	
	public Car fetchModelDetails(String modelName, String carName) throws ClassNotFoundException, SQLException;
}
