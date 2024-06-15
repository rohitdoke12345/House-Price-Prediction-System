package org_house.predict.model;

public class CityMasterModel {
	private int cityId;
	private String cityName;
	
	public CityMasterModel(int cityId,String cityName) {
		this.cityId=cityId;
		this.cityName=cityName;
	}
	public CityMasterModel() {
		
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
