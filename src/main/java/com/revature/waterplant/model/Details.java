package com.revature.waterplant.model;

public class Details {
	
	private double availability_List;
	private double quantyList;
	private double reservedList;
	private double reservedOrder;
	private double quanty;
	private String status;

	
	public double getAvailability_List() {
		return availability_List;
	}

	public void setAvailability_List(double availability_List) {
		this.availability_List = availability_List;
	}

	public double getQuantyList() {
		return quantyList;
	}

	public void setQuantyList(double quantyList) {
		this.quantyList = quantyList;
	}

	public double getReservedList() {
		return reservedList;
	}

	public void setReservedList(double reservedList) {
		this.reservedList = reservedList;
	}

	public double getReservedOrder() {
		return reservedOrder;
	}

	public void setReservedOrder(double reservedOrder) {
		this.reservedOrder = reservedOrder;
	}

	public double getQuanty() {
		return quanty;
	}

	public void setQuanty(double quanty) {
		this.quanty = quanty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
