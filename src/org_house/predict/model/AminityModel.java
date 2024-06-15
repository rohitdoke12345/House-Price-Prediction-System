package org_house.predict.model;

public class AminityModel {
    private int aminityid;
    private String aminityname;
    public AminityModel() {
    	
    }
    public AminityModel(int aminityid,String aminityname) {
    	this.aminityid=aminityid;
    	this.aminityname=aminityname;
    }
	public int getAminityid() {
		return aminityid;
	}
	public void setAminityid(int aminityid) {
		this.aminityid = aminityid;
	}
	public String getAminityname() {
		return aminityname;
	}
	public void setAminityname(String aminityname) {
		this.aminityname = aminityname;
	}
}
