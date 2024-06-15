package org_house.predict.service;

import org_house.predict.model.PropertyModel;
import org_house.predict.repository.PropertyRepository;

public class PropertyService {
	
	PropertyRepository proprepo =new PropertyRepository();
	public boolean isAddnewproperty(PropertyModel model) {
		return proprepo.isAddnewproperty(model);
		
	}
}
