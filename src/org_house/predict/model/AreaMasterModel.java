package org_house.predict.model;

public class AreaMasterModel extends CityMasterModel {
	private int area_id;
	private String area_name;
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public AreaMasterModel() {
		
	}
	public AreaMasterModel(int area_id,String area_name) {
		this.area_id=area_id;
		this.area_name=area_name;
	}

}
