package com.wxl.entity;

import java.util.Date;

/**
 * TSignin entity. @author MyEclipse Persistence Tools
 */

public class TSignin implements java.io.Serializable {

	// Fields

	private Integer signinid;
	private TUsers TUsers;
	private String state;
	private Date indate;

	// Constructors

	/** default constructor */
	public TSignin() {
	}

	/** full constructor */
	public TSignin(TUsers TUsers, String state, Date indate) {
		this.TUsers = TUsers;
		this.state = state;
		this.indate = indate;
	}

	// Property accessors

	public Integer getSigninid() {
		return this.signinid;
	}

	public void setSigninid(Integer signinid) {
		this.signinid = signinid;
	}

	public TUsers getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(TUsers TUsers) {
		this.TUsers = TUsers;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getIndate() {
		return this.indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

}