package org_house.predict.repository;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org_house.predict.config.DBHelper;
import org_house.predict.config.DBconfig;
import org_house.predict.config.PathHelper;
import org_house.predict.model.AreaMasterModel;
import org_house.predict.model.CityMasterModel;

public class CityMasterRepository extends DBHelper {

	private int areaId = 0;
	int value;
	private List<Object[]> cityWiseAreaCount;
	private LinkedHashMap<String, Integer> map;
	private LinkedHashMap <String,ArrayList<String>>map1;

	public boolean isAddNewCity(CityMasterModel model) {
		try {

			stmt = conn.prepareStatement("insert into cityMaster values('0',?)");
			stmt.setString(1, model.getCityName());
			value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("error is " + ex);
			return false;
		}

	}

	public List<CityMasterModel> getAllCity() {
		try {
			List<CityMasterModel> list = new ArrayList<CityMasterModel>();
			stmt = conn.prepareStatement("select *from cityMaster");
			rs = stmt.executeQuery();
			while (rs.next()) {
				CityMasterModel model = new CityMasterModel();
				model.setCityId(rs.getInt(1));
				model.setCityName(rs.getString(2));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("error ex :" + ex);
			return null;
		}

	}

	public boolean isAddBulkCities() throws SQLException {
		try {
			FileReader fr = new FileReader(PathHelper.path + "cities.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String data[] = line.split(",");
				stmt = conn.prepareStatement("insert into cityMaster values('0',?)");
				stmt.setString(1, data[1]);
				value = stmt.executeUpdate();

			}

			return value > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int GetCityId(String cityName) {
		try {
			stmt = conn.prepareStatement("select city_Id from citymaster where city_name=?");
			stmt.setString(1, cityName);
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

	public int getIdAutomatically() {
		try {
			stmt = conn.prepareStatement("select max(area_id) from areaMaster");
			rs = stmt.executeQuery();
			if (rs.next()) {
				this.rs.getInt(1);
			}
			areaId++;
			return areaId;
		} catch (Exception ex) {
			System.out.println("error is :" + ex);
			return 0;
		}
	}

	public boolean isAddArea(AreaMasterModel areamodel) {
		try {
			CallableStatement cstmt = conn.prepareCall("{call savearea(?,?,?)}");
			cstmt.setInt(1, areamodel.getArea_id());
			cstmt.setString(2, areamodel.getArea_name());
			cstmt.setInt(3, areamodel.getCityId());
			boolean b = cstmt.execute();
			return !b;

		} catch (Exception ex) {
			System.out.println("error is :" + ex);
			return false;
		}

	}
//	public List<Object[]> getCityWiseAreaCount(){ 
//		try {
//			this.cityWiseAreaCount=new ArrayList<Object[]>();
//			stmt=conn.prepareStatement("select cm.city_name ,count(caj.city_id) from citymaster cm inner join cityareajoin caj on cm.city_id=caj.city_id\r\n"
//					+ "inner join areamaster am on caj.area_id=am.area_id group by cm.city_name");
//			rs=stmt.executeQuery();
//			while(rs.next()) {
//				Object obj[]=new Object[] {rs.getString(1),rs.getInt(2)};
//				this.cityWiseAreaCount.add(obj);
//				
//			}
//			return this.cityWiseAreaCount;
//		}catch(Exception ex) {
//			System.out.println("error is"+ex);
//			return null;
//		}
//	}

	public LinkedHashMap<String, Integer> getCityWiseAreaCount() {
		try {
			map = new LinkedHashMap<String, Integer>();
			stmt = conn.prepareStatement(
					"select cm.city_name ,count(caj.city_id) from citymaster cm inner join cityareajoin caj on cm.city_id=caj.city_id\r\n"
							+ "inner join areamaster am on caj.area_id=am.area_id group by cm.city_name");
			rs = stmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));

			}
			return map;
		} catch (Exception ex) {
			System.out.println("error is" + ex);
			return null;
		}
	}

	public LinkedHashMap<String,ArrayList<String>> getCityWiseAreaNames(){
		try {
			this.map1=new LinkedHashMap <String,ArrayList<String>>();
			stmt=conn.prepareStatement("select city_name from cityMaster");
			rs=stmt.executeQuery();
			while(rs.next()) {
				  String cityName=rs.getString(1);
				PreparedStatement stmt1=conn.prepareStatement("select am.area_name from citymaster cm inner join "
						+ "cityareajoin caj on cm.city_id=caj.city_id inner join areamaster am on caj.area_id=am.area_id where cm.city_name=?");
			    stmt1.setString(1, cityName);
			     ResultSet rs1=stmt1.executeQuery();
			     ArrayList <String> areaname=new ArrayList<String>();
			     while(rs1.next()) {
			    	 areaname.add(rs1.getString(1));
			    	 
			     }
			     this.map1.put(cityName, areaname);
			}
			return map1;
		}catch(Exception ex)
		{
			System.out.println("error is :"+ex);
			return null;
		}
	}
}
