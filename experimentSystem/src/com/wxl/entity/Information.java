package com.wxl.entity;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */

public class Information implements java.io.Serializable {

	// Fields

	private Integer informationid;
	private String informationtitle;
	private String information;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** full constructor */
	public Information(String informationtitle, String information) {
		this.informationtitle = informationtitle;
		this.information = information;
	}

	// Property accessors

	public Integer getInformationid() {
		return this.informationid;
	}

	public void setInformationid(Integer informationid) {
		this.informationid = informationid;
	}

	public String getInformationtitle() {
		return this.informationtitle;
	}

	public void setInformationtitle(String informationtitle) {
		this.informationtitle = informationtitle;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}