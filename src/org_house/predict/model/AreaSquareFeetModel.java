package org_house.predict.model;

public class AreaSquareFeetModel {
	private int sqid;
	private int SquareFeet;
	public AreaSquareFeetModel() {
		
	}
	public AreaSquareFeetModel(int SquareFeet) {
		this.SquareFeet=SquareFeet;
	}
	public int getSqid() {
		return sqid;
	}
	public void setSqid(int sqid) {
		this.sqid = sqid;
	}
	public int getSquareFeet() {
		return SquareFeet;
	}
	public void setSquareFeet(int squareFeet) {
		SquareFeet = squareFeet;
	}
	
}
