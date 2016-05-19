package com.dishtech.dao;

import java.sql.SQLException;

import com.dishtech.beans.Car;

public interface ICarDAO {

	public Car searchCars(String name) throws ClassNotFoundException, SQLException;
	public Car fetchDetails(String modelName,String carName) throws SQLException, ClassNotFoundException;
	public void getConnection() throws ClassNotFoundException, SQLException;
	
}
