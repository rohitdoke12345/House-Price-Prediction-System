package org_house.predict.service;

import org_house.predict.model.AreaSquareFeetModel;
import org_house.predict.repository.AreaSquareFeetRepository;

public class AreaSquareFeetService {
	AreaSquareFeetRepository arearepo=new AreaSquareFeetRepository();
		public boolean isAddSquareFeet(AreaSquareFeetModel model) {
			return arearepo.isAddSquareFeet(model);
		}
		public int getSquareFeetid(int squarefeet) {
		return 	arearepo.getSquareFeetid(squarefeet);
		}
}
