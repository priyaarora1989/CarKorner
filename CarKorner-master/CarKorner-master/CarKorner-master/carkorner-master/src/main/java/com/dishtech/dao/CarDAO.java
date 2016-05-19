package com.dishtech.dao;

import java.sql.*;
import java.util.ArrayList;
import com.dishtech.beans.Car;
import com.dishtech.beans.Model;
import com.dishtech.beans.Specifications;
import com.dishtech.beans.UsedCar;

public class CarDAO implements ICarDAO{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Car car = new Car();
	
	@SuppressWarnings("null")
	public Car searchCars(String name) throws ClassNotFoundException, SQLException{
		
		
		ArrayList<Model> list = new ArrayList<Model>();
		
		String carName = name;
		System.out.println("--- car name entred is :" +carName);
		ps = con.prepareStatement("select * from carkorner.car");
		rs=ps.executeQuery();
		System.out.println("---- query executed -----");
		
			while(rs.next())
				{
					int carId=rs.getInt(1);
					System.out.println(" car id is: " +carId);
					
					String dCarName=rs.getString(2);
					car.setCarName(dCarName);
					System.out.println(" database car name :" +dCarName);
					
					Float carPrice = rs.getFloat(3);
					car.setCarPrice(carPrice);
					System.out.println(" car price is :" +carPrice);
					
					if(dCarName.equalsIgnoreCase(carName))
					{
						System.out.println(" ---- enter if -----");
						ps = con.prepareStatement("select * from carkorner.car_model where carId=?");
						ps.setInt(1, carId);
						rs= ps.executeQuery();
						System.out.println("----- query executed ------");
						
						while(rs.next())
						{
							Model model = new Model();
							
							Float modelId = rs.getFloat(2);
							model.setModelId(modelId);
							System.out.println(" model id is : " +modelId);
							
							String modelName=rs.getString(3);
							model.setModelName(modelName);
							System.out.println(" model name is :" +modelName);
							
							list.add(model);
						}
						car.setList(list);
					}
				}
	//Obtain connection, fetch the data from database and populate bean
	System.out.println("--- return car -----");
	return car;
	}
	
	public Car fetchDetails(String modelName,String carName) throws SQLException, ClassNotFoundException
	{
		int i = 2;
		
		Float mId= (float) 1.01;
		ArrayList<String> colorName = new ArrayList<String>();
		
		System.out.println(" model name is :" +modelName);
		System.out.println("---- enter cardao in fetch details ----");
		ps=con.prepareStatement("select * from carkorner.model_colors WHERE modelid IN(SELECT modelid FROM carkorner.car_model WHERE modelname=?)");
		ps.setString(1,modelName);
		rs=ps.executeQuery();

		System.out.println(" -- query executed ----");
		
		while(rs.next())
		{
			System.out.println("enter while");
			while(i<8)
			{
			 colorName.add(rs.getString(i));
			 System.out.println("color name is " +rs.getString(i));
			i++;
			}
		}
		
		System.out.println(" carname " +carName);

		ps = con.prepareStatement("select carPrice from carkorner.car where carname=?");
		ps.setString(1,carName);
		rs = ps.executeQuery();
		Float carPrice = null;
		System.out.println("carprice query executed ");
		while(rs.next())
		{
			System.out.println(" enter while ");
			carPrice=rs.getFloat(1);
		}
		
		ps=con.prepareStatement("SELECT * FROM carkorner.model_features WHERE modelid IN(SELECT modelid FROM carkorner.car_model WHERE modelname=?)");
		ps.setString(1,modelName);
		rs=ps.executeQuery();
		System.out.println(" features query executed ");
			
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		
		while(rs.next())
		{	
			System.out.println(" -- enter feature while ---");
			
			int airBag = rs.getInt(2);
			car.setAirBags(airBag);
			
			Boolean dualStorageAirBags = rs.getBoolean(3);
			list.add(dualStorageAirBags);
			
			Boolean ABS = rs.getBoolean(4);
			list.add(ABS);
			
			Boolean EBD = rs.getBoolean(5);
			list.add(EBD);
			
			Boolean BA = rs.getBoolean(6);
			list.add(BA);
			
			Boolean ESP = rs.getBoolean(7);
			list.add(ESP);
			
			Boolean fourWheelDrive = rs.getBoolean(8);
			list.add(fourWheelDrive);
			
			Boolean hillHoldControl = rs.getBoolean(9);
			list.add(hillHoldControl);
			
			Boolean engineMobilizer = rs.getBoolean(10);
			list.add(engineMobilizer);
			
			Boolean centralLocking = rs.getBoolean(11);
			list.add(centralLocking);
			
			Boolean speedSensoredDoorLock = rs.getBoolean(12);
			list.add(speedSensoredDoorLock);
			
			Boolean childSafetyLock = rs.getBoolean(13);
			list.add(childSafetyLock);
		}
		
		Specifications sp = new Specifications();
		
		ps=con.prepareStatement("select * from carkorner.model_specifications  WHERE modelid IN(SELECT modelid FROM carkorner.car_model WHERE modelname=?)");
		ps.setString(1, modelName);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			sp.setWheelBase(rs.getLong(2));
			System.out.println(" wheelbase is :" +rs.getLong(2));
			
			sp.setGroundClearance(rs.getLong(3));
			System.out.println(" wheelbase is :" +rs.getLong(3));
			
			sp.setKERWeight(rs.getLong(4));
			System.out.println(" kerweight is :" +rs.getLong(4));
			
			sp.setDoors(rs.getLong(5));
			System.out.println(" doors is  :" +rs.getLong(5));
			
			sp.setSeatingCapacity(rs.getLong(6));
			System.out.println(" seating capacity  is :" +rs.getLong(5));
			
			sp.setNoOfSeatingSpace(rs.getLong(7));
			System.out.println(" No of seating space  is :" +rs.getLong(7));
			
			sp.setBootSpace(rs.getLong(8));
			System.out.println(" Bootspace is is :" +rs.getLong(8));
			
			sp.setFuelTankCapacity(rs.getLong(9));
			System.out.println(" fuel tank capa is :" +rs.getLong(9));
			
			sp.setFuelType(rs.getString(10));
			System.out.println(" fule type is :" +rs.getString(10));
			
			
			sp.setMaxTorque(rs.getLong(11));
			System.out.println(" Maxtorque is :" +rs.getLong(11));
			
			sp.setMileage(rs.getLong(12));
			System.out.println(" Mileage is :" +rs.getLong(12));
			
			sp.setDisplacement(rs.getLong(13));
			System.out.println(" Displacement is :" +rs.getLong(13));
			
			sp.setMaxPower(rs.getLong(14));
			System.out.println("MAXpower is :" +rs.getLong(14));
			
			sp.setCylinders(rs.getLong(15));
			System.out.println(" cylinder is :" +rs.getLong(15));
			
			sp.setTurboChargers(rs.getBoolean(16));
			System.out.println(" Turbo charger is :" +rs.getBoolean(16));
			
			sp.setTurboChargersType(rs.getBoolean(17));
			System.out.println(" turbocharger tupe is :" +rs.getBoolean(17));
			
			sp.setValve(rs.getString(18));
			System.out.println(" valve is is :" +rs.getString(18));
			
			sp.setNoOfGears(rs.getLong(19));
			System.out.println(" gears is :" +rs.getLong(19));
			
			sp.setTransmissionType(rs.getString(20));
			System.out.println(" Transmission type  is :" +rs.getString(20));
			
			sp.setDriveTrain(rs.getString(21));
			System.out.println("Drive train  is :" +rs.getString(21));
			
			sp.setDualClutch(rs.getBoolean(22));
			System.out.println(" Dual clutch is :" +rs.getBoolean(22));
			
			sp.setSportMode(rs.getBoolean(23));
			System.out.println(" sports mode  is :" +rs.getBoolean(23));
			
			sp.setDrivingMode(rs.getBoolean(24));
			System.out.println(" driving modee is :" +rs.getBoolean(24));
		}
		
		car.setSp(sp);
		car.setFeature(list);
		car.setCarName(carName);
		car.setModelName(modelName);
		car.setCarPrice(carPrice);
		car.setColorName(colorName);
		return car ;
	}
	
	public int sellCar(UsedCar usedcar)
	{
		UsedCar uc = new UsedCar();
		uc=usedcar;
		
		uc.getCarName();
		System.out.println("carname is :" +uc.getCarName());
		
		return 0;
		
	}
	
	public void getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		System.out.println("----- driver loaded----");
		
		con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		System.out.println("--- connection established-----");
		
		System.out.println(" -- create statement ----");
		// TODO Auto-generated constructor stub
	}
	
	
}
