package com.dishtech.beans;

//This is a used car bean.
public class UsedCar {

	 private String carName,color,city;
	 private Long price,modelYear;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getModelYear() {
		return modelYear;
	}
	public void setModelYear(Long modelYear) {
		this.modelYear = modelYear;
	}
}
