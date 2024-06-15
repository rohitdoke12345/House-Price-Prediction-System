package org_house.predict.client;

import java.util.*;

import org_house.predict.model.AminityModel;
import org_house.predict.model.AreaMasterModel;
import org_house.predict.model.AreaSquareFeetModel;
import org_house.predict.model.CityMasterModel;
import org_house.predict.model.DealModel;
import org_house.predict.model.PropertyModel;
import org_house.predict.service.AminityService;
import org_house.predict.service.AreaMasterService;
import org_house.predict.service.AreaSquareFeetService;
import org_house.predict.service.CityMasterService;
import org_house.predict.service.PropertyService;

import java.sql.*;

public class ClientApplication {

	public static void main(String[] args) {

		CityMasterService cms = new CityMasterService();
		AreaSquareFeetService squarefeetservice =new AreaSquareFeetService();
		AminityService aminityservice=new AminityService();
		 AreaMasterService ams=new AreaMasterService();
		 PropertyService propservice=new PropertyService();
		do {
			Scanner sc = new Scanner(System.in);
			int choice;
			System.out.println("\n1.add new city");
			System.out.println("2.View all cities");
			System.out.println("3.Add bulk city");
			System.out.println("4.Add new area");            System.out.println("5.citywise area counting..");
            System.out.println("6.cityWise AreasNames.");
            System.out.println("7.add square feet area of property");
            System.out.println("8.add the aminity ");
            System.out.println("9.add new property");
			System.out.println("ENTER YOUR CHOICE");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("enter city name");
				String cityName = sc.nextLine();
				CityMasterModel model = new CityMasterModel();
				model.setCityName(cityName);
				boolean b = cms.isAddCity(model);
				if (b) {
					System.out.println("City added Successfully");
				} else {
					System.out.println("Some problem is there..");
				}
				break;
			case 2:
				List <CityMasterModel> list=cms.getAllCity();
				if (list!=null) {
					for (CityMasterModel m:list) {
						System.out.println(m.getCityId()+"\t"+m.getCityName());
					}
				}else {
					System.out.println("No City Present");
				}
				cms.getAllCity();
				break;
			case 3:
				//add bulk cities 
				 try {
					b =cms.isAddBulkCities();
					if(b) {
						System.out.println("cities added successfully.......");
					}else {
						System.out.println("some problem is here...");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter the city name to add area");
				 cityName=sc.nextLine();
				int cityId=cms.GetCityId(cityName);
				if (cityId!=-1) {
//					System.out.println(+cityId);
					System.out.println("Enter the Area name");
					String areaName=sc.nextLine();
					int areaId=cms.getIdAutomatically();
					AreaMasterModel areamodel=new AreaMasterModel();
					areamodel.setArea_id(areaId);
					areamodel.setArea_name(areaName);
					areamodel.setCityId(cityId);
					 b =cms.isAddArea(areamodel);
					 if(b) {
						System.out.println("Area added Successfully..");
					 }else {
						 System.out.println("Area not added some problem is there..");
					 }
				}else {
					System.out.println("city not present in databases");
					System.out.println("Do you want to add this city in database table yes or no");
					String msg=sc.nextLine();
					if (msg.equalsIgnoreCase("yes")) {
						model = new CityMasterModel();
						model.setCityName(cityName);
						 b = cms.isAddCity(model);
						if (b) {
							System.out.println("City added Successfully");
						} else {
							System.out.println("Some problem is there..");
						}
					}else {
						System.out.println("Thank you..");
					}
				}
				break;
			case 5:
				LinkedHashMap<String,Integer> map=cms.getCityWiseAreaCount();
				Set<Map.Entry<String, Integer>> data=map.entrySet();
				for(Map.Entry<String, Integer> c:data) {
					System.out.println(c.getKey()+"\t"+c.getValue());
				}
				break;
			case 6:
				LinkedHashMap <String,ArrayList<String>>map1=cms.getCityWiseAreaNames();
				Set<Map.Entry<String, ArrayList<String>>>set=map1.entrySet();
				for(Map.Entry<String, ArrayList<String>>d:set) {
					
					ArrayList <String> values=d.getValue();
					if(values.size()>0) {
						System.out.println(d.getKey());
						System.out.println("===============================");
					for(String val:values) {
						System.out.println(val);
					}
					System.out.println("===============================\n\n");
					}
					
				}
				break;
			case 7:
				System.out.println("Enter Area value in Square feet");
				int squarefeet=sc.nextInt();
				AreaSquareFeetModel squarefeetmodel =new AreaSquareFeetModel();
				squarefeetmodel.setSquareFeet(squarefeet);
				 b = squarefeetservice.isAddSquareFeet(squarefeetmodel);
				if (b) {
					System.out.println("Square feet added successfully");
				}
				else {
					System.out.println("some problem is there..");
				}
				break;
			case 8:
				sc.nextLine();
				System.out.println("Enter the aminity names");
				String aminityname=sc.nextLine();
				AminityModel aminitymodel=new AminityModel();
				aminitymodel.setAminityname(aminityname);
				 b = aminityservice.isAddAminity(aminitymodel);
				if (b) {
					System.out.println("Aminity added successfully");
				}
				else {
					System.out.println("some problem is there..");
				}
				break;
			case 9:
				sc.nextLine();
				System.out.println("Enter the city name");
				String cityname=sc.nextLine();
				int cityid=cms.GetCityId(cityname);
//				System.out.println(cityid);
				
				
				System.out.println("Enter the area name");
				String areaname=sc.nextLine();
				System.out.println("Enter the address of property i.e name of property");
				String name=sc.nextLine();
				
				AreaMasterModel m=new AreaMasterModel();
				m.setCityName(cityname);
				m.setArea_name(areaname);
				int areaid=ams.getAreaid(m);
				m.setArea_id(areaid);
				m.setCityId(cityid);
//				System.out.println(areaid);
				
				System.out.println("Enter the number of room(bed) and number of bathrooms");
				int nbed=sc.nextInt();
				int nbath=sc.nextInt();
			
				System.out.println("Enter the SquareFeet area");
				int squarefeetarea=sc.nextInt();
				int sqid=squarefeetservice.getSquareFeetid(squarefeetarea);
				if (sqid==-1) {
					System.out.println("there is some exception");
				} if(sqid==0)
				{
					System.out.println("square feet area not present do you want to add new square feet area");
					 squarefeetmodel =new AreaSquareFeetModel();
					squarefeetmodel.setSquareFeet(squarefeetarea);
					 b = squarefeetservice.isAddSquareFeet(squarefeetmodel);
					if (b) {
						System.out.println("Square feet added successfully");
						sqid=squarefeetservice.getSquareFeetid(squarefeetarea);
					}
					else {
						System.out.println("some problem is there..");
					}
					
				}
			
				
				List <AminityModel> aminitylist=new ArrayList<AminityModel>();
				sc.nextLine();
				String str="";
				do {
//					sc.nextLine();
					System.out.println("Enter the Aminity name");
					 aminityname=sc.nextLine();
					 aminitymodel=new AminityModel();
					 
					 aminitymodel.setAminityname(aminityname);
					 int amid=aminityservice.getaminityid(aminityname);
					 aminitymodel.setAminityid(amid);
					 
					 aminitylist.add(aminitymodel);
					 System.out.println("do you want to add more aminities");
					 str=sc.nextLine();
					
				}while(str.equalsIgnoreCase("yes"));
				PropertyModel propmodel = new PropertyModel();
				propmodel.setName(name);
				propmodel.setNbath(nbath);
				propmodel.setNbed(nbed);
				propmodel.setAreamodel(m);
				squarefeetmodel=new AreaSquareFeetModel();
				squarefeetmodel.setSquareFeet(squarefeetarea);
				squarefeetmodel.setSqid(sqid);
				propmodel.setSquarefeetmodel(squarefeetmodel);
				propmodel.setList(aminitylist);
				System.out.println("enter the price ");
				int price =sc.nextInt();
				sc.nextLine();
//				String rdate=sc.nextLine();
				DealModel dmodel=new DealModel();
//				dmodel.setDate(rdate);
				dmodel.setPrice(price);
				propmodel.setDealmodel(dmodel);
				b=propservice.isAddnewproperty(propmodel);
				if (b) {
					System.out.println("new property added successfully...");
				}else {
					System.out.println("some problem is there");
				}
				break;
			}
		} while (true);

	}

}
