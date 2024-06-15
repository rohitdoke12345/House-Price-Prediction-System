package org_house.predict.model;
import java.util.*;
public class PropertyModel {
    private int pid ;
    private String name;
    private AreaMasterModel areamodel;
    private List<AminityModel> list;
    public int getPid() {
		return pid;
	}
	public List<AminityModel> getList() {
		return list;
	}
	public void setList(List<AminityModel> list) {
		this.list = list;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AreaMasterModel getAreamodel() {
		return areamodel;
	}
	public void setAreamodel(AreaMasterModel areamodel) {
		this.areamodel = areamodel;
	}
	

	public AreaSquareFeetModel getSquarefeetmodel() {
		return squarefeetmodel;
	}
	public void setSquarefeetmodel(AreaSquareFeetModel squarefeetmodel) {
		this.squarefeetmodel = squarefeetmodel;
	}
	public int getNbed() {
		return nbed;
	}
	public void setNbed(int nbed) {
		this.nbed = nbed;
	}
	public int getNbath() {
		return nbath;
	}
	public void setNbath(int nbath) {
		this.nbath = nbath;
	}
	private AreaSquareFeetModel squarefeetmodel;
    private int nbed;
    private int nbath;
    private DealModel dealmodel;
	public DealModel getDealmodel() {
		return dealmodel;
	}
	public void setDealmodel(DealModel dealmodel) {
		this.dealmodel = dealmodel;
	}
    
}
