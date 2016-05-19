package com.dishtech.beans;

import java.util.ArrayList;

//This is a car bean.
public class Car {
	
	private String carName,modelName;
	private Float modelId;
	private Float carPrice;
	private int airBags;
	private ArrayList<Model> list = new ArrayList<Model>();
	private ArrayList<String> colorName = new ArrayList<String>();
	private ArrayList<Boolean> feature = new ArrayList<Boolean>();
	Specifications sp = new Specifications();
	
	
	public Specifications getSp() {
		return sp;
	}

	public void setSp(Specifications sp) {
		this.sp = sp;
	}

	public ArrayList<Boolean> getFeature() {
		return feature;
	}

	public void setFeature(ArrayList<Boolean> feature) {
		this.feature = feature;
	}

	public int getAirBags() {
		return airBags;
	}

	public void setAirBags(int airBags) {
		this.airBags = airBags;
	}
	
	public ArrayList<String> getColorName() {
		return colorName;
	}

	public Float getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(Float carPrice) {
		this.carPrice = carPrice;
	}


	public void setColorName(ArrayList<String> colorName) {
		this.colorName = colorName;
	}
	
	public ArrayList<Model> getList() {
		return list;
	}

	public void setList(ArrayList<Model> list) {
		this.list = list;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Float getModelId() {
		return modelId;
	}

	public void setModelId(Float modelId) {
		this.modelId = modelId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

}
