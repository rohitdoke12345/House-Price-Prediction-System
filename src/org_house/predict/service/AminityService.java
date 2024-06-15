package org_house.predict.service;

import org_house.predict.model.AminityModel;
import org_house.predict.repository.AminityRepository;

public class AminityService {
	AminityRepository aminityrepo=new AminityRepository();
     public boolean isAddAminity(AminityModel model)
     {
    	 return aminityrepo.isAddAminity(model);
     }
     public int getaminityid(String aminityname) {
    	 return aminityrepo.getaminityid(aminityname);
     }
}
