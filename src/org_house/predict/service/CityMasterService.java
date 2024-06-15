package org_house.predict.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org_house.predict.model.AreaMasterModel;
import org_house.predict.model.CityMasterModel;
import org_house.predict.repository.CityMasterRepository;

public class CityMasterService {
	CityMasterRepository cityrepo = new CityMasterRepository();
	

	public boolean isAddCity(CityMasterModel model) {
		boolean b = cityrepo.isAddNewCity(model);
		return b;
	}
	public List<CityMasterModel> getAllCity(){
		return cityrepo.getAllCity();
		
	}
	public boolean isAddBulkCities( ) throws SQLException {
		return cityrepo.isAddBulkCities();
	}
	public int GetCityId (String cityName) {
		return cityrepo.GetCityId(cityName);
	}
	public int getIdAutomatically() {
		return cityrepo.getIdAutomatically();
	}
	
	public boolean isAddArea(AreaMasterModel areamodel) {
		return cityrepo.isAddArea(areamodel);
	}
	public LinkedHashMap <String,Integer> getCityWiseAreaCount(){
		return this.cityrepo.getCityWiseAreaCount();
	}
	public LinkedHashMap<String,ArrayList<String>> getCityWiseAreaNames(){
		return this.cityrepo.getCityWiseAreaNames();
	}
}
