package org_house.predict.repository;

import org_house.predict.config.DBHelper;
import org_house.predict.model.AreaMasterModel;

public class AreaMasterRepository extends DBHelper{

	public int getAreaid(AreaMasterModel model) {
		try {
			stmt=conn.prepareStatement("select am.area_id from areamaster am inner join cityAreajoin caj on am.area_id=caj.area_id inner join citymaster cm on caj.city_id=cm.city_id where am.area_name=? and cm.city_name=?");
			stmt.setString(1, model.getArea_name());
			stmt.setString(2, model.getCityName());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}else {
				return 0;
			}
			
		}catch(Exception ex) {
			System.out.println("error is:"+ex);
			return -1;
		}
		
	}
        
}
