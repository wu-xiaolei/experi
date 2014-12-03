package com.wxl.entity;

/**
 * TExperiment entity. @author MyEclipse Persistence Tools
 */

public class TExperiment implements java.io.Serializable {

	// Fields

	private Integer experid;
	private TUsers TUsers;
	private String expername;
	private String teacher;
	private String class_;
	private Integer score;
	private String expercontent;

	// Constructors

	/** default constructor */
	public TExperiment() {
	}

	/** minimal constructor */
	public TExperiment(TUsers TUsers, String expername, Integer score) {
		this.TUsers = TUsers;
		this.expername = expername;
		this.score = score;
	}

	/** full constructor */
	public TExperiment(TUsers TUsers, String expername, String teacher,
			String class_, Integer score, String expercontent) {
		this.TUsers = TUsers;
		this.expername = expername;
		this.teacher = teacher;
		this.class_ = class_;
		this.score = score;
		this.expercontent = expercontent;
	}

	// Property accessors

	public Integer getExperid() {
		return this.experid;
	}

	public void setExperid(Integer experid) {
		this.experid = experid;
	}

	public TUsers getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(TUsers TUsers) {
		this.TUsers = TUsers;
	}

	public String getExpername() {
		return this.expername;
	}

	public void setExpername(String expername) {
		this.expername = expername;
	}

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getExpercontent() {
		return this.expercontent;
	}

	public void setExpercontent(String expercontent) {
		this.expercontent = expercontent;
	}

}