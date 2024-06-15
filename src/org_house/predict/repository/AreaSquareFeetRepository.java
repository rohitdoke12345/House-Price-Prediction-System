package org_house.predict.repository;

import org_house.predict.config.DBHelper;
import org_house.predict.model.AreaSquareFeetModel;

public class AreaSquareFeetRepository extends DBHelper{
		public boolean isAddSquareFeet(AreaSquareFeetModel model) {
		  try {
			  stmt=conn.prepareStatement("insert into areasquarefeet values('0',?) ");
			  stmt.setInt(1, model.getSquareFeet());
			  int value =stmt.executeUpdate();
			  return value>0?true:false;
		  }catch(Exception ex) {
             System.out.println("error is :"+ex);
 			return false;
		  }
	}
		public int getSquareFeetid(int squarefeet) {
			try {
				stmt=conn.prepareStatement("select sqid from areasquarefeet");
				rs=stmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}else {
					return 0;
				}
			}catch(Exception ex) {
				System.out.println("error is :"+ex);
				return -1;
			}
		}
}
