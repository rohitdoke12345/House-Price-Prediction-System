package org_house.predict.repository;

import java.util.List;

import org_house.predict.config.DBHelper;
import org_house.predict.model.AminityModel;
import org_house.predict.model.DealModel;
import org_house.predict.model.PropertyModel;
import java.util.*;
public class PropertyRepository extends DBHelper{
     
	int pid;
	public int getpropertyIdAuto() {
		try {
			stmt=conn.prepareStatement("select max(pid) from propertymaster");
			rs=stmt.executeQuery();
			if(rs.next()) {
				pid=rs.getInt(1);
			}
			return ++pid;
		}catch(Exception ex) {
			System.out.println("error is "+ex);
			return 0;
		}
	}
	public boolean isAddnewproperty(PropertyModel model) {
		 pid=this.getpropertyIdAuto();
		String pname=model.getName();
		int aid=model.getAreamodel().getArea_id();
		int cid=model.getAreamodel().getCityId();
		int sqid=model.getSquarefeetmodel().getSqid();
		int nbed =model.getNbed();
		int nbath=model.getNbath();
		
//		    System.out.println("propertymaster.............");
//		    System.out.println("Property ID (pid): " + (pid+1));
//	        System.out.println("Property Name (pname): " + pname);
//	        System.out.println("Area ID (aid): " + aid);
//	        System.out.println("City ID (cid): " + cid);
//	        System.out.println("Square Feet ID (sqid): " + sqid);
//	        System.out.println("Number of Bedrooms (nbed): " + nbed);
//	        System.out.println("Number of Bathrooms (nbath): " + nbath);
		try {
			stmt=conn.prepareStatement("insert into propertymaster values(?,?,?,?,?,?,?)");
			stmt.setInt(1,pid);
			stmt.setString(2, pname);
			stmt.setInt(3, sqid);
			stmt.setInt(4,aid);
			stmt.setInt(5, cid);
			stmt.setInt(6, nbed);
			stmt.setInt(7, nbath);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				List<AminityModel> list=model.getList();
		        System.out.println("Aminityes");
		        int count=0;
		        for(AminityModel m:list) {
		        	stmt=conn.prepareStatement("insert into propertyaminityjoin values(?,?)");
		        	stmt.setInt(1, pid);
		        	stmt.setInt(2, m.getAminityid());
		        	value=stmt.executeUpdate();
		        	
		        }
		        DealModel dealmodel=model.getDealmodel();
		        Date d=dealmodel.getDate();
		        int price =dealmodel.getPrice();
		        stmt=conn.prepareStatement("insert into historicalprices values('0',?,?,(select curDate()))");
		        stmt.setInt(1, pid);
		        stmt.setInt(2, price);
		        value =stmt.executeUpdate();
		        if(value>0) {
//		        System.out.println(pid+"\t"+dealmodel.getPrice()+"\t"+dealmodel.getDate());
		        	System.out.println("property added successfully...");
		        	return true;
		        }else {
		        	System.out.println("property not added");
		        	return false;
		        }
			}else {
				System.out.println("some problem is there");
				return false;
			}
		}catch(Exception ex) {
			System.out.println("error is :"+ex);
			return false;
		}

		
	}
}
