package org_house.predict.repository;

import org_house.predict.config.DBHelper;
import org_house.predict.model.AminityModel;

public class AminityRepository extends DBHelper {
	public boolean isAddAminity(AminityModel model)
	
	{
		try {
			stmt=conn.prepareStatement("insert into AminityMaster values('0',?)");
			stmt.setString(1, model.getAminityname());
			int value =stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception ex) {
			System.out.println("error is :"+ex);
			return false;
		}
		
	}
	public int getaminityid(String aminityname) {
		try {
			stmt = conn.prepareStatement("select aminityid from aminitymaster where aminityname=?");
			stmt.setString(1, aminityname);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception ex) {
			System.out.println("erorr is :" + ex);
			return -1;
		}
		
	}
}
