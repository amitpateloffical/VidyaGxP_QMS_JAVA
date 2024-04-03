package com.inn.qms.wrapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)
public class CapaWrapper {

	String name;
	String site;
	String flowName;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSite() {
		return site;
	}



	public void setSite(String site) {
		this.site = site;
	}



	public String getFlowName() {
		return flowName;
	}



	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}



	@Override
	public String toString() {
		return "CapaWrapper [name=" + name + ", site=" + site + ", flowName=" + flowName + "]";
	}
	
	
	
}
