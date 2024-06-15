package org_house.predict.service;

import org_house.predict.model.AreaMasterModel;
import org_house.predict.repository.AreaMasterRepository;

public class AreaMasterService {
	AreaMasterRepository areamasterrepo=new AreaMasterRepository();
    public int getAreaid(AreaMasterModel model)
    {
    	return areamasterrepo.getAreaid( model);
    }
}
