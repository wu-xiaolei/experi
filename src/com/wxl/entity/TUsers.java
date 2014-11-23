package com.wxl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TUsers entity. @author MyEclipse Persistence Tools
 */

public class TUsers implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String userno;
	private String username;
	private String password;
	private String class_;
	private Integer grade;
	private Set TSignins = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUsers() {
	}

	/** minimal constructor */
	public TUsers(String userno, String username, String password, Integer grade) {
		this.userno = userno;
		this.username = username;
		this.password = password;
		this.grade = grade;
	}

	/** full constructor */
	public TUsers(String userno, String username, String password,
			String class_, Integer grade, Set TSignins) {
		this.userno = userno;
		this.username = username;
		this.password = password;
		this.class_ = class_;
		this.grade = grade;
		this.TSignins = TSignins;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserno() {
		return this.userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Set getTSignins() {
		return this.TSignins;
	}

	public void setTSignins(Set TSignins) {
		this.TSignins = TSignins;
	}

}